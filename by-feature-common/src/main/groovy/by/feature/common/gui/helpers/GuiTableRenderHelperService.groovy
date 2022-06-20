package by.feature.common.gui.helpers

import by.feature.common.events.GuiRenderingEvent
import grails.artefact.Artefact
import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import org.springframework.context.event.EventListener
import org.springframework.core.ResolvableType



@Artefact("Service")
@Slf4j
class GuiTableRenderHelperService {



    protected GrailsApplication grailsApplication


    GuiTableRenderHelperService(GrailsApplication grailsApplication) {
        this.grailsApplication = grailsApplication
    }



    @EventListener(condition="#event.name.startsWith('gui.render.crud.list.content.table')")
    void onCrudTableRendering(GuiRenderingEvent event ){

        log.debug "onCrudTableRendering - BEGIN"

        List<String> renders = null

        if((event.context.domainClass != null)){
            renders = Arrays.asList(this.grailsApplication.mainContext.getBeanNamesForType(ResolvableType.forClassWithGenerics(IGuiTableRenderHelper, event.context.domainClass)))
        }


//        if((renders == null)||(renders.isEmpty())){
//            renders = Arrays.asList(this.grailsApplication.mainContext.getBeanNamesForType(ResolvableType.forClass(IGuiTableRenderHelper)))
//        }


        for(String beanName in renders){

            log.debug "onCrudTableRendering - found Render : [${beanName}]"

            //Collections.sort(list,AnnotationAwareOrderComparator.INSTANCE);

            IGuiTableRenderHelper renderBean = this.grailsApplication.mainContext.getBean(beanName)

            NodeBuilder builder = new NodeBuilder()
            Node tableModel     = renderBean.defineTableModel(builder)

            event.context.put("tableModel",tableModel)
            renderBean.renderThis(event)


            log.debug "onCrudTableRendering - ${tableModel}"

            //renderBean.renderThis(event)

        }

        log.debug "onCrudTableRendering - END"
    }


}
