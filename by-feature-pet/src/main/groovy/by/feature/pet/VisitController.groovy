package by.feature.pet

import grails.validation.ValidationException
import grails.web.Controller

import static org.springframework.http.HttpStatus.*


@Controller
class VisitController {

    VisitService visitService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond visitService.list(params), model:[visitCount: visitService.count()]
    }

    def show(Long id) {
        respond visitService.get(id)
    }

    def create() {
        respond new Visit(params)
    }

    def save(Visit visit) {
        if (visit == null) {
            notFound()
            return
        }

        try {
            visitService.save(visit)
        } catch (ValidationException e) {
            respond visit.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'visit.label', default: 'Visit'), visit.id])
                redirect visit
            }
            '*' { respond visit, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond visitService.get(id)
    }

    def update(Visit visit) {
        if (visit == null) {
            notFound()
            return
        }

        try {
            visitService.save(visit)
        } catch (ValidationException e) {
            respond visit.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'visit.label', default: 'Visit'), visit.id])
                redirect visit
            }
            '*'{ respond visit, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        visitService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'visit.label', default: 'Visit'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'visit.label', default: 'Visit'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
