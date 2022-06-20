package by.feature.common.events.taglib

import by.feature.common.events.GuiRenderingEvent
import by.feature.common.events.HookEventsService
import grails.artefact.Artefact
import grails.gsp.TagLib
import groovy.util.logging.Slf4j
import org.grails.core.artefact.gsp.TagLibArtefactHandler


@TagLib
@Slf4j
class HookTagLib {

    static namespace = "hook"

    //static defaultEncodeAs = [taglib:'html']

    HookEventsService hookEventsService


    def executeHook = { attrs, body ->
        //out << body() << (attrs.happy == 'true' ? " :-)" : " :-(")

        Map<String,Object> context = new HashMap()
        context.putAll(attrs)

        hookEventsService.executeHook( attrs.hookName , context )

    }



    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]




    def renderWithHook = { attrs, body ->
        //out << body() << (attrs.happy == 'true' ? " :-)" : " :-(")

        Map<String,Object> context = new HashMap()
        context.putAll(attrs)

        //Map<String,Object> renderingContext = new HashMap()
        //renderingContext.put('unrenderedBody', body)
        //renderingContext.put('renderedBody'  , body())

        //context.put("gui.tag.rendering", renderingContext)
        //context.put( "gui.output", body() )

        GuiRenderingEvent event = GuiRenderingEvent.builder()
                                                   .name(attrs.hookName)
                                                   .source(this.grailsApplication)
                                                   .context(context)
                                                   .build()

        event.setGuiOutput(null)
        //def event = hookEventsService.executeHookAndReturn( attrs.hookName , context )

        event = hookEventsService.executeHookAndReturn( event )

        //renderingContext = event.context."gui.tag.rendering"
        def tagOutput = event.getGuiOutput() == null ? body() : event.getGuiOutput()

        //out << renderingContext.renderedBody
        out << tagOutput

    }



}
