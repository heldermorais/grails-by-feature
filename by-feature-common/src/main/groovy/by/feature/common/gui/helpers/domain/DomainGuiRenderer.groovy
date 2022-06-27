package by.feature.common.gui.helpers.domain

import groovy.xml.DOMBuilder

import java.lang.reflect.ParameterizedType

abstract class DomainGuiRenderer<T> {

    protected Class<T> domainClass

    DomainGuiRenderer(){
        this.domainClass = inferDomainClazzFromController()
    }


    Class<?> inferDomainClazzFromController() {

        ParameterizedType t         = (ParameterizedType) this.class.getGenericSuperclass() // OtherClass<String>

        Class<?> domnClazz = null

        if(t != null){
            domnClazz          = (Class<?>) t.getActualTypeArguments()[0] // Class<String>
        }

        return domnClazz

    }


    def renderDomain(){
        def nodeBuilder = new NodeBuilder()

        def studentlist = nodeBuilder.userlist {
            user(id: '1', studentname: 'John', Subject: 'Chemistry')
            user(id: '2', studentname: 'Joe', Subject: 'Maths')
            user(id: '3', studentname: 'Mark', Subject: 'Physics')
        }
    }


    static void main(String[] args) {
        def nodeBuilder = new DOMBuilder()

        def studentlist = nodeBuilder.domainRendered {
            field(bean: '1', studentname: 'John', Subject: 'Chemistry')
            user(id: '2', studentname: 'Joe', Subject: 'Maths')
            user(id: '3', studentname: 'Mark', Subject: 'Physics')
        }

        println studentlist
    }
}
