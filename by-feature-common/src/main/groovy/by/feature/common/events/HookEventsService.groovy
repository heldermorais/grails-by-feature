package by.feature.common.events

import grails.artefact.Artefact
import grails.core.GrailsApplication

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import org.springframework.context.event.EventListener


//@Artefact("Service")
@Transactional
@Slf4j
class HookEventsService {


    protected GrailsApplication grailsApplication


    HookEventsService(GrailsApplication grailsApplication) {
        this.grailsApplication = grailsApplication
    }


    void executeHook( String hookName ) {

        HexaGenericEvent event = HexaGenericEvent.builderWith().name(hookName).source(this.grailsApplication).build()

        this.grailsApplication.mainContext.publishEvent(event)

    }


    void executeHook( String hookName , Map<String,Object> context ) {

        HexaGenericEvent event = HexaGenericEvent.builder().name(hookName).source(this.grailsApplication).context( context ).build()

        this.grailsApplication.mainContext.publishEvent(event)

    }


    HexaGenericEvent executeHookAndReturn( String hookName , Map<String,Object> context ) {

        HexaGenericEvent event = HexaGenericEvent.builder().name(hookName).source(this.grailsApplication).context( context ).build()

        this.grailsApplication.mainContext.publishEvent(event)

        return event

    }

    HexaGenericEvent executeHookAndReturn( HexaGenericEvent event , Map<String,Object> context ) {

        event.context.putAll(context)

        this.grailsApplication.mainContext.publishEvent(event)

        return event

    }

    HexaGenericEvent executeHookAndReturn( HexaGenericEvent event  ) {

        this.grailsApplication.mainContext.publishEvent(event)

        return event

    }



    @EventListener
    void onEveryEvent (HexaGenericEvent event){
         log.debug " ... evento : ${event.name} type: ${event.class.name}"
    }

}
