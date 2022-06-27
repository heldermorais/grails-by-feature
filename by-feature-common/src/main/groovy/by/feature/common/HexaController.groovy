package by.feature.common

import by.feature.common.events.HookEventsService
import by.feature.common.gui.IGuiLayoutHelper
import grails.artefact.Artefact
import grails.core.GrailsApplication
import grails.util.GrailsNameUtils
import grails.validation.ValidationException
import grails.web.Controller
import grails.web.servlet.mvc.GrailsParameterMap
import groovy.util.logging.Slf4j
import org.grails.core.artefact.ControllerArtefactHandler
import org.springframework.beans.factory.InitializingBean
import org.springframework.core.annotation.AnnotationUtils


import java.lang.reflect.ParameterizedType

import static org.springframework.http.HttpStatus.*



@Controller
@Slf4j
abstract class HexaController<T,U> {

    protected GrailsApplication grailsApplication

    protected U                 useCaseService
    protected Class<?>          domainClazz

    protected Class<?>          useCaseImplClazz

    protected String            domainPropName
    protected String            domainRepName

    protected HookEventsService hookEventsService
    protected def groovyPageLocator

    protected IGuiLayoutHelper guiLayoutHelper


    HexaController(GrailsApplication grailsApplication, U useCaseService){

        this.grailsApplication   = grailsApplication
        this.useCaseService      = useCaseService


        this.domainClazz            = inferDomainClazzFromUseCaseService(useCaseService)

        if(this.domainClazz == null){
            this.domainClazz            = inferDomainClazzFromController()
        }


        if(this.domainClazz == null){
            throw new RuntimeException(" This Controller MUST be linked to an 'U useCase' class")
        }


//        ParameterizedType t         = (ParameterizedType) this.class.getGenericSuperclass() // OtherClass<String>
//
//        this.domainClazz            = (Class<?>) t.getActualTypeArguments()[0] // Class<String>
//        //this.useCaseImplClazz       = (Class<?>) t.getActualTypeArguments()[1] // Class<String>
//


        this.domainPropName         = GrailsNameUtils.getPropertyNameRepresentation(this.domainClazz)
        this.domainRepName          = GrailsNameUtils.getNaturalName( this.domainPropName )

        //this.useCaseService         = this.grailsApplication.mainContext.getBean(this.useCaseImplClazz)

        this.hookEventsService      = this.grailsApplication.mainContext.getBean("hookEventsService")
        this.groovyPageLocator      = this.grailsApplication.mainContext.getBean("groovyPageLocator")

        this.guiLayoutHelper        = this.grailsApplication.mainContext.getBean("guiLayoutHelper")

    }





    def index(Integer max) {

        //params.max = Math.min(max ?: 10, 100)
        params.remove("max")
        def lista  = useCaseService.list(params)

        executeHook("controller.index", [lista: lista])

        if(groovyPageLocator != null){
            if(groovyPageLocator.findView("index") != null){
                respond lista, model:[
                                      listCount        : useCaseService.count(),
                                      entityTypeName   : this.domainPropName,
                                      defaultEntityName: this.domainRepName,
                                      domainClass      : this.domainClazz
                                     ]
            }else{
                render (view: guiLayoutHelper.getAbsolutePathFor("pages/crud/list"), //'/templates/common/pages/crud/list',
                        model:[
                                list             : lista,
                                listCount        : useCaseService.count(),
                                entityTypeName   : this.domainPropName,
                                defaultEntityName: this.domainRepName,
                                domainClass      : this.domainClazz
                              ]
                )
            }
        }else{
            respond lista, model:[
                                  listCount        : useCaseService.count(),
                                  entityTypeName   : this.domainPropName,
                                  defaultEntityName: this.domainRepName,
                                  domainClass      : this.domainClazz
                                 ]
        }

    }

    protected void executeHook(String hookName, Map<String, Object> payload = null) {

        HashMap<String,Object> context = new HashMap<String,Object>()

        Map<String,Object> req = new HashMap<String,Object>()

        req.controllerName = controllerName
        req.actionName     = actionName
        req.params         = params
        req.original       = request

        context.put("request", req)

        Map<String, Object> resp = new HashMap<String,Object>()
        context.put("response", new HashMap<String,Object>())


        if(payload != null){
           resp.put("data",payload)
        }


        hookEventsService.executeHook(hookName, context)

    }


    def create() {

        def domain       = newDomainInstance()
        domain.properties   = params

        domain = afterDomainInstanceCreated(domain,params)

        executeHook("controller.create", [domain: domain])


        if(groovyPageLocator != null){
            if(groovyPageLocator.findView("create") != null){
                respond domain, view:'create', model: [
                                                       domain           : domain,
                                                       entityTypeName   : this.domainPropName,
                                                       defaultEntityName: this.domainRepName
                                                      ]
            }else{
                render (view: guiLayoutHelper.getAbsolutePathFor("pages/crud/create"), //'/templates/common/pages/crud/create',
                        model:[
                                domain: domain,
                                entityTypeName   : this.domainPropName,
                                defaultEntityName: this.domainRepName
                              ]
                )
            }
        }else{
            respond domain, view: 'create', model: [
                                                    domain           : domain,
                                                    entityTypeName   : this.domainPropName,
                                                    defaultEntityName: this.domainRepName
                                                   ]
        }
        //respond domain, model:[domain: domain]

    }

    protected T afterDomainInstanceCreated (T domain, GrailsParameterMap params){
        return domain
    }

    protected T newDomainInstance() {

        return this.domainClazz.newInstance()
    }




    def show(Long id) {

        def domain = useCaseService.get(id)

        executeHook("controller.show", [domain: domain])



        if(groovyPageLocator != null){
            if(groovyPageLocator.findView("show") != null){
                respond domain, model: [
                                        domain           : domain,
                                        entityTypeName   : this.domainPropName,
                                        defaultEntityName: this.domainRepName
                                       ]
            }else{
                render (view: guiLayoutHelper.getAbsolutePathFor("pages/crud/show"), //'/templates/common/pages/crud/show',
                        model:[
                                domain: domain,
                                entityTypeName   : this.domainPropName,
                                defaultEntityName: this.domainRepName
                              ]
                )
            }
        }else{
            respond domain, model: [
                                    domain           : domain,
                                    entityTypeName   : this.domainPropName,
                                    defaultEntityName: this.domainRepName
                                   ]
        }



    }


    def edit(Long id) {

        def domain = useCaseService.get(id)

        executeHook("controller.edit", [domain: domain])


        if(groovyPageLocator != null){
            if(groovyPageLocator.findView("edit") != null){
                respond domain, model: [
                                        domain           : domain,
                                        entityTypeName   : this.domainPropName,
                                        defaultEntityName: this.domainRepName
                                       ]
            }else{
                render (view: guiLayoutHelper.getAbsolutePathFor("pages/crud/edit"), //'/templates/common/pages/crud/edit',
                        model:[
                                domain           : domain,
                                entityTypeName   : this.domainPropName,
                                defaultEntityName: this.domainRepName
                              ]
                )
            }
        }else{
            respond domain, model: [
                                    domain           : domain,
                                    entityTypeName   : this.domainPropName,
                                    defaultEntityName: this.domainRepName
                                   ]
        }



    }



    def save() {

        T domain = this.newDomainInstance()
        domain.properties = params

        executeHook("controller.beforeSave", [domain: domain])

        domain = beforeNewDomainSaved(domain, params)

        if (domain == null) {
            notFound()
            return
        }

        try {
            useCaseService.save(domain)

            executeHook("controller.afterSave", [domain: domain])

        } catch (ValidationException e) {
            //respond domain.errors, view:'create', model: [domain: domain]

            if(groovyPageLocator != null){
                if(groovyPageLocator.findView("create") != null){
                    respond domain.errors, view:'create', model: [
                                                                  domain           : domain,
                                                                  entityTypeName   : this.domainPropName,
                                                                  defaultEntityName: this.domainRepName
                                                                 ]
                }else{
                    render (view: guiLayoutHelper.getAbsolutePathFor("pages/crud/create"), //'/templates/common/pages/crud/create',
                            model:[
                                    domain           : domain,
                                    entityTypeName   : this.domainPropName,
                                    defaultEntityName: this.domainRepName
                            ]
                    )
                }
            }else{
                respond domain.errors, view: 'create', model: [
                                                               domain           : domain,
                                                               entityTypeName   : this.domainPropName,
                                                               defaultEntityName: this.domainRepName
                                                              ]
            }

            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = getOnSaveErrorMessage( domain )
                redirect domain
            }
            '*' { respond domain , [status: CREATED] }
        }


    }

    protected String getOnSaveErrorMessage (T domain){
        return message(code: "default.created.message", args: [message(code: "${this.domainPropName}.label", default: this.domainPropName), domain.id])
    }

    protected T beforeNewDomainSaved (T domain, GrailsParameterMap params){
        return domain
    }



    def update(Long id) {

        if (id == null) {
            notFound()
            return
        }


        T domain = useCaseService.get(id)
        domain.properties = params

        executeHook("controller.beforeUpdate", [domain: domain])
        domain = beforeDomainInstanceUpdated(domain, params)

        if (domain == null) {
            notFound()
            return
        }

        try {
            useCaseService.save(domain)

            executeHook("controller.afterUpdate", [domain: domain])

        } catch (ValidationException e) {
            //respond domain.errors, view:'edit'
            if(groovyPageLocator != null){
                if(groovyPageLocator.findView("edit") != null){
                    respond domain.errors, view:'edit', model: [
                                                                domain           : domain,
                                                                entityTypeName   : this.domainPropName,
                                                                defaultEntityName: this.domainRepName
                                                               ]
                }else{
                    render (view: guiLayoutHelper.getAbsolutePathFor("pages/crud/edit"), //'/templates/common/pages/crud/edit',
                            model:[
                                    domain           : domain,
                                    entityTypeName   : this.domainPropName,
                                    defaultEntityName: this.domainRepName
                                  ]
                    )
                }
            }else{
                respond domain.errors, view: 'edit', model: [
                                                             domain: domain,
                                                             entityTypeName   : this.domainPropName,
                                                             defaultEntityName: this.domainRepName
                                                            ]
            }

            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = getOnUpdateErrorMessage( domain )
                redirect domain
            }
            '*'{ respond domain, [status: OK] }
        }

    }

    protected String getOnUpdateErrorMessage (T domain){
        return message(code: 'default.updated.message', args: [message(code: "${domainPropName}.label", default: this.domainPropName), domain.id])
    }

    protected T beforeDomainInstanceUpdated (T domain, GrailsParameterMap params){
        return domain
    }



    def delete(Long id) {


        if (id == null) {
            notFound()
            return
        }

        T domain = useCaseService.get(id)

        executeHook("controller.beforeDelete", [domain: domain])
        domain   = beforeDomainInstanceDeleted(domain,params)


        if (domain == null) {
            notFound()
            return
        }

        useCaseService.delete(id)

        executeHook("controller.afterDelete", [domain: domain, id: id])

        request.withFormat {
            form multipartForm {
                flash.message = getOnDeleteErrorMessage(id)
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }

    }

    protected String getOnDeleteErrorMessage (Long domainId){
        return message(code: 'default.deleted.message', args: [message(code: "${domainPropName}.label", default: this.domainPropName), domainId])
    }

    protected T beforeDomainInstanceDeleted (T domain, GrailsParameterMap params){
        return domain
    }



    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = this.getNotFoundMessage( params.id )
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }




    protected String getNotFoundMessage (Long domainId ){
        return message(code: 'default.not.found.message', args: [message(code: "${domainPropName}.label", default: this.domainPropName), domainId])
    }



//    @Override
//    void afterPropertiesSet() throws Exception {
//
//
//        ParameterizedType t         = (ParameterizedType) this.class.getGenericSuperclass() // OtherClass<String>
//
//        this.domainClazz            = (Class<?>) t.getActualTypeArguments()[0] // Class<String>
//        this.useCaseImplClazz       = (Class<?>) t.getActualTypeArguments()[1] // Class<String>
//
//        this.domainPropName         = GrailsNameUtils.getPropertyNameRepresentation(this.domainClazz)
//        this.domainRepName          = GrailsNameUtils.getNaturalName( this.domainPropName )
//
//        this.useCaseService         = this.grailsApplication.mainContext.getBean(this.useCaseImplClazz)
//
//        this.hookEventsService      = this.grailsApplication.mainContext.getBean(HookEventsService)
//
//
//    }


    Class<?> inferDomainClazzFromUseCaseService(U useCaseService) {
        grails.gorm.services.Service srvAnnotation = AnnotationUtils.findAnnotation(useCaseService.class, grails.gorm.services.Service)
        Class<?> domnClazz = null
        if(srvAnnotation != null){
            domnClazz = srvAnnotation.value()
        }
        return domnClazz
    }

    Class<?> inferDomainClazzFromController() {

        ParameterizedType t         = (ParameterizedType) this.class.getGenericSuperclass() // OtherClass<String>

        Class<?> domnClazz = null

        if(t != null){
            domnClazz          = (Class<?>) t.getActualTypeArguments()[0] // Class<String>
        }

        return domnClazz

    }
}
