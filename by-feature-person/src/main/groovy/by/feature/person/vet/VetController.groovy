package by.feature.person.vet

import grails.validation.ValidationException
import grails.web.Controller

import static org.springframework.http.HttpStatus.*

@Controller
class VetController {

    VetService vetService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vetService.list(params), model:[vetCount: vetService.count()]
    }

    def show(Long id) {
        respond vetService.get(id)
    }

    def create() {
        respond new Vet(params)
    }

    def save(Vet vet) {
        if (vet == null) {
            notFound()
            return
        }

        try {
            vetService.save(vet)
        } catch (ValidationException e) {
            respond vet.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vet.label', default: 'Vet'), vet.id])
                redirect vet
            }
            '*' { respond vet, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vetService.get(id)
    }

    def update(Vet vet) {
        if (vet == null) {
            notFound()
            return
        }

        try {
            vetService.save(vet)
        } catch (ValidationException e) {
            respond vet.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vet.label', default: 'Vet'), vet.id])
                redirect vet
            }
            '*'{ respond vet, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vetService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vet.label', default: 'Vet'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vet.label', default: 'Vet'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
