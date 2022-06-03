package by.feature.pet

import grails.validation.ValidationException
import grails.web.Controller

import static org.springframework.http.HttpStatus.*


@Controller
class PetTypeController {

    PetTypeService petTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond petTypeService.list(params), model:[petTypeCount: petTypeService.count()]
    }

    def show(Long id) {
        respond petTypeService.get(id)
    }

    def create() {
        respond new PetType(params)
    }

    def save(PetType petType) {
        if (petType == null) {
            notFound()
            return
        }

        try {
            petTypeService.save(petType)
        } catch (ValidationException e) {
            respond petType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'petType.label', default: 'PetType'), petType.id])
                redirect petType
            }
            '*' { respond petType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond petTypeService.get(id)
    }

    def update(PetType petType) {
        if (petType == null) {
            notFound()
            return
        }

        try {
            petTypeService.save(petType)
        } catch (ValidationException e) {
            respond petType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'petType.label', default: 'PetType'), petType.id])
                redirect petType
            }
            '*'{ respond petType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        petTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'petType.label', default: 'PetType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'petType.label', default: 'PetType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
