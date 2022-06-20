package by.feature.common.events

import groovy.transform.builder.Builder
import org.springframework.context.ApplicationEvent


//@Builder
class HexaGenericEvent extends ApplicationEvent {

    String name
    Map    context


    HexaGenericEvent( Object source, String name, Map context ) {
        super(source)
        this.name = name
        this.context = context
    }


    HexaGenericEvent(Object source, String name){
        super(source)
        this.name = name
        this.context = new HashMap<String,Object>()
    }



    @Builder(builderClassName='Hexa1EventBuilder', builderMethodName='builder')
    static HexaGenericEvent createMe ( Object source, String name, Map context ){
        return new HexaGenericEvent(source, name, context)
    }

    @Builder(builderClassName='Hexa2EventBuilder', builderMethodName='builderWith')
    static HexaGenericEvent createMe2 ( Object source, String name ){
        return new HexaGenericEvent(source, name)
    }



}

