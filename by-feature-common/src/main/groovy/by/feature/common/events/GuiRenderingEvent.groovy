package by.feature.common.events

import groovy.transform.builder.Builder

class GuiRenderingEvent extends HexaGenericEvent{

    GuiRenderingEvent(Object source, String name, Map context) {
        super(source, name, context)
    }

    GuiRenderingEvent(Object source, String name) {
        super(source, name)
    }

    @Builder(builderClassName='GuiHexaEventBuilder', builderMethodName='builder')
    static GuiRenderingEvent createMe ( Object source, String name, Map context ){
        return new GuiRenderingEvent(source, name, context)
    }

    void setGuiOutput ( guiOutput ){
        this.context.put( "gui.output", guiOutput )
    }

    def getGuiOutput(){
        this.context.get("gui.output")
    }
}
