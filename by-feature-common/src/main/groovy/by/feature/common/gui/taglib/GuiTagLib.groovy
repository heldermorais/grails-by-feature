package by.feature.common.gui.taglib

import by.feature.common.artefacts.ByFeatureTaglib
import by.feature.common.gui.IGuiLayoutHelper
import grails.artefact.Artefact
import grails.gsp.TagLib
import org.grails.core.artefact.gsp.TagLibArtefactHandler


@ByFeatureTaglib
class GuiTagLib {

    static namespace = "gui"


    IGuiLayoutHelper guiLayoutHelper

    //static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def navigationMenu = { attrs, body ->

          int menuState = attrs.menuState

//        def bodyStr = body()
//
//        out << body()

//         def menuState = attrs.menuState ? attrs.menuState : ENavigationMenuState.LISTING

         pageScope.navigationMenuState = menuState



         //out << g.render(template: "/templates/common/navigation/navigation-menu", model: [innerBody: body()])
        out << g.render(template: guiLayoutHelper.getAbsolutePathFor( "navigation/navigation-menu") , model: [innerBody: body()])

    }


    def navMenuItem = { attrs, body ->

        def menuStates = attrs.menuStates ? attrs.menuStates : [pageScope.navigationMenuState]

        String bodyStr = body()

//        out << body()

//        def menuState = attrs.menuState ? attrs.menuState : ENavigationMenuState.LISTING

        def label = null
        if((bodyStr != null)&&(!bodyStr.trim().isEmpty())){
            label = bodyStr
        }else{
            label = attrs.label
        }

        if (pageScope.navigationMenuState in menuStates){
           //out << g.render(template: "/templates/common/navigation/navigation-menu-item", model: [href: attrs.href, cssClasses: attrs.cssClasses, label: label])
            out << g.render(template: guiLayoutHelper.getAbsolutePathFor( "navigation/navigation-menu-item"),
                            model: [
                                    href: attrs.href,
                                    cssClasses: attrs.cssClasses,
                                    label: label,
                                    iconName: attrs.iconName
                            ])
        }


    }

}
