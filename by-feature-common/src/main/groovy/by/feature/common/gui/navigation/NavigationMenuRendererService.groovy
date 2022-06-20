package by.feature.common.gui.navigation

import grails.artefact.Artefact
import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional
import grails.util.GrailsNameUtils
import grails.web.mapping.LinkGenerator
import org.grails.core.artefact.ServiceArtefactHandler
import org.springframework.context.MessageSource
import org.springframework.web.servlet.i18n.SessionLocaleResolver



@Artefact(ServiceArtefactHandler.TYPE)
class NavigationMenuRendererService {


    protected GrailsApplication grailsApplication

    protected Class<?> domainClazz
    protected String   domainPropName
    protected String   domainRepName
    protected String   entityName

    protected MessageSource messageSource
    protected SessionLocaleResolver localeResolver
    protected LinkGenerator grailsLinkGenerator



    NavigationMenuRendererService(GrailsApplication grailsApplication) {

        this.grailsApplication   = grailsApplication

        this.messageSource       = this.grailsApplication.mainContext.getBean("messageSource")
        this.localeResolver      = this.grailsApplication.mainContext.getBean("localeResolver")
        this.grailsLinkGenerator = this.grailsApplication.mainContext.getBean("grailsLinkGenerator")

    }


    protected String message(String code, List args){
        return messageSource.getMessage(code, args.toArray(), localeResolver.defaultLocale)
    }

    protected String message(String code, List args, String defaultValue){
        return messageSource.getMessage(code, args.toArray(), defaultValue, localeResolver.defaultLocale)
    }


    NavigationMenuRenderer<?> getMenuRendererFor( Class<?> domainClass ) {

        this.domainPropName      = GrailsNameUtils.getPropertyNameRepresentation(domainClass)
        this.domainRepName       = GrailsNameUtils.getNaturalName( this.domainPropName )

        this.entityName          = message("${this.domainPropName}.label", [], this.domainRepName)

    }


}
