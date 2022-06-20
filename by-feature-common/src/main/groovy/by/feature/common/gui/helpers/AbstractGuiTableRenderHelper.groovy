package by.feature.common.gui.helpers

import by.feature.common.events.GuiRenderingEvent

import java.lang.reflect.ParameterizedType

abstract class AbstractGuiTableRenderHelper<D> implements IGuiTableRenderHelper<D> {


    protected Class<?>          domainClazz


    AbstractGuiTableRenderHelper() {

        ParameterizedType t         = (ParameterizedType) this.class.getGenericSuperclass() // OtherClass<String>
        this.domainClazz            = (Class<?>) t.getActualTypeArguments()[0] // Class<String>

    }



    @Override
    CharSequence renderThis(GuiRenderingEvent event) {

        return null
    }

}
