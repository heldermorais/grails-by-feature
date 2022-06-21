package by.feature.common.gui.taglib

import by.feature.common.artefacts.ByFeatureTaglib
import grails.artefact.Artefact
import grails.gsp.TagLib
import org.grails.core.artefact.gsp.TagLibArtefactHandler


@ByFeatureTaglib
class GuiHelperTagLib {

    static namespace = "gui"
    //static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def navMenuItem = { attrs, body ->
        //out << body() << (attrs.happy == 'true' ? " :-)" : " :-(")

        String

        Map<String,Object> context = new HashMap()
        context.putAll(attrs)

        //hookEventsService.executeHook( attrs.hookName , context )

    }
}
