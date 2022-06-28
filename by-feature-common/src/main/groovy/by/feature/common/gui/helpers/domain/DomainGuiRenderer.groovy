package by.feature.common.gui.helpers.domain

import groovy.xml.DOMBuilder
import groovy.xml.MarkupBuilder

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

        def writer = new StringWriter()
        def html = new MarkupBuilder(writer)
        html.html {
            head {
                title 'Simple document'
            }
            body(id: 'main') {
                h1 'Building HTML the Groovy Way'
                p {
                    mkp.yield 'Mixing text with '
                    strong 'bold'
                    mkp.yield ' elements.'
                }
                a href: 'more.html', 'Read more...'
            }
        }
        println writer

    }
}
