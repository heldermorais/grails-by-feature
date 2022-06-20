package by.feature.common.gui.navigation

import by.feature.common.gui.navigation.item.MenuItem
import grails.core.GrailsApplication
import grails.util.GrailsNameUtils
import grails.web.mapping.LinkGenerator
import org.springframework.context.MessageSource
import org.springframework.web.servlet.i18n.SessionLocaleResolver


import java.lang.reflect.ParameterizedType

abstract class NavigationMenuRenderer<D> implements IDomainNavigationMenuRenderer<D>{


    protected GrailsApplication grailsApplication
    protected Class<D> domainClazz
    protected String domainPropName
    protected String domainRepName
    protected String entityName

    protected MessageSource messageSource
    protected SessionLocaleResolver localeResolver
    protected LinkGenerator grailsLinkGenerator



    NavigationMenuRenderer(GrailsApplication grailsApplication, MessageSource messageSource, SessionLocaleResolver localeResolver, LinkGenerator grailsLinkGenerator) {
        this.grailsApplication   = grailsApplication
        this.messageSource       = messageSource
        this.localeResolver      = localeResolver
        this.grailsLinkGenerator = grailsLinkGenerator

        ParameterizedType t      = (ParameterizedType) this.class.getGenericSuperclass() // OtherClass<String>

        this.domainClazz         = (Class<?>) t.getActualTypeArguments()[0] // Class<String>

        this.domainPropName      = GrailsNameUtils.getPropertyNameRepresentation(this.domainClazz)
        this.domainRepName       = GrailsNameUtils.getNaturalName( this.domainPropName )

        this.entityName          = message("${this.domainPropName}.label", [], this.domainRepName)
    }



    public String message(String code, List args){
        return messageSource.getMessage(code, args.toArray(), localeResolver.defaultLocale)
    }

    public String message(String code, List args, String defaultValue){
        return messageSource.getMessage(code, args.toArray(), defaultValue, localeResolver.defaultLocale)
    }


    protected MenuItem menuitemHome() {
        MenuItem
                .builder()
                .cssClasses("home")
                .href(grailsLinkGenerator.link(uri: '/'))
                .label(message('default.home.label', []))
                .build()
    }

    protected MenuItem menuitemList() {
        MenuItem
                .builder()
                .cssClasses("list")
                .href(grailsLinkGenerator.link(action: 'index', controller: this.domainPropName))
                .label(message('default.list.label', [this.entityName]))
                .build()
    }

    protected MenuItem menuitemCreate() {
        MenuItem
                .builder()
                .cssClasses("create")
                .href(grailsLinkGenerator.link(action: 'create', controller: this.domainPropName))
                .label(message('default.new.label', [this.entityName]))
                .build()
    }



    protected Collection<MenuItem> buildNavigationMenuWhenListing(){
        ArrayList<MenuItem> menu = new ArrayList<>()
        menu.add (
                menuitemHome()
        )
        menu.add (
                menuitemCreate()
        )

        return menu
    }

    protected Collection<MenuItem> buildNavigationMenuWhenInserting(){
        ArrayList<MenuItem> menu = new ArrayList<>()
        menu.add (
                menuitemHome()
        )
        menu.add (
                menuitemList()
        )
        return menu
    }

    protected Collection<MenuItem> buildNavigationMenuWhenShowing(){

        ArrayList<MenuItem> menu = new ArrayList<>()
        menu.add (
                menuitemHome()
        )
        menu.add (
                menuitemList()
        )
        menu.add (
                menuitemCreate()
        )

        return menu
    }

    protected Collection<MenuItem> buildNavigationMenuWhenEditing(){

        return buildNavigationMenuWhenShowing()
    }

    protected Collection<MenuItem> buildNavigationMenuWhenDeleting(){

        return buildNavigationMenuWhenShowing()
    }


    @Override
    Collection<MenuItem> buildNavigationMenuFor( Integer state ) {
        ArrayList<MenuItem> menu = new ArrayList<>()

        switch (state){
            case ENavigationMenuState.LISTING: // Listing
                menu.addAll( this.buildNavigationMenuWhenListing() )
                break;
            case ENavigationMenuState.SHOWING_ONE: //Showing
                menu.addAll( this.buildNavigationMenuWhenShowing() )
                break;
            case ENavigationMenuState.EDITING_ONE: //Editing
                menu.addAll( this.buildNavigationMenuWhenEditing() )
                break;
            case ENavigationMenuState.DELETING_ONE: //deleting
                menu.addAll( this.buildNavigationMenuWhenShowing() )
                break;

            case ENavigationMenuState.INSERTING_ONE: //Inserting
                menu.addAll( this.buildNavigationMenuWhenInserting() )
                break;
        }

        return menu
    }
}
