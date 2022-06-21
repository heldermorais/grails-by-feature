package by.feature.person.vet

import by.feature.common.CommonHexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication
import grails.validation.ValidationException
import grails.web.Controller

import static org.springframework.http.HttpStatus.*

@ByFeatureController
class VetController extends CommonHexaController<Vet, VetDataService>{


    VetController(GrailsApplication grailsApplication, VetDataService vetDataService) {
        super(grailsApplication, vetDataService)
    }



//    VetDataService vetDataService
//
//    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
//
//    def index(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
//        respond vetDataService.list(params), model:[vetCount: vetDataService.count()]
//    }
//
//    def show(Long id) {
//        respond vetDataService.get(id)
//    }
//
//    def create() {
//        respond new Vet(params)
//    }
//
//    def save(Vet vet) {
//        if (vet == null) {
//            notFound()
//            return
//        }
//
//        try {
//            vetDataService.save(vet)
//        } catch (ValidationException e) {
//            respond vet.errors, view:'create'
//            return
//        }
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.created.message', args: [message(code: 'vet.label', default: 'Vet'), vet.id])
//                redirect vet
//            }
//            '*' { respond vet, [status: CREATED] }
//        }
//    }
//
//    def edit(Long id) {
//        respond vetDataService.get(id)
//    }
//
//    def update(Vet vet) {
//        if (vet == null) {
//            notFound()
//            return
//        }
//
//        try {
//            vetDataService.save(vet)
//        } catch (ValidationException e) {
//            respond vet.errors, view:'edit'
//            return
//        }
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.updated.message', args: [message(code: 'vet.label', default: 'Vet'), vet.id])
//                redirect vet
//            }
//            '*'{ respond vet, [status: OK] }
//        }
//    }
//
//    def delete(Long id) {
//        if (id == null) {
//            notFound()
//            return
//        }
//
//        vetDataService.delete(id)
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vet.label', default: 'Vet'), id])
//                redirect action:"index", method:"GET"
//            }
//            '*'{ render status: NO_CONTENT }
//        }
//    }
//
//    protected void notFound() {
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vet.label', default: 'Vet'), params.id])
//                redirect action: "index", method: "GET"
//            }
//            '*'{ render status: NOT_FOUND }
//        }
//    }


}
