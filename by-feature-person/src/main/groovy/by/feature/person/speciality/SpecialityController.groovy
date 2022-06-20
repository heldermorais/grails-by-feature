package by.feature.person.speciality

import grails.validation.ValidationException
import grails.web.Controller

import static org.springframework.http.HttpStatus.*

@Controller
class SpecialityController {

    protected SpecialityDataService specialityDataService

    SpecialityController(SpecialityDataService specialityDataService){
        this.specialityDataService = specialityDataService
    }

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond specialityDataService.list(params), model:[specialityCount: specialityDataService.count()]
    }

    def show(Long id) {
        respond specialityDataService.get(id)
    }

    def create() {
        respond new Speciality(params)
    }

    def save(Speciality speciality) {
        if (speciality == null) {
            notFound()
            return
        }

        try {
            specialityDataService.save(speciality)
        } catch (ValidationException e) {
            respond speciality.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'speciality.label', default: 'Speciality'), speciality.id])
                redirect speciality
            }
            '*' { respond speciality, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond specialityDataService.get(id)
    }

    def update(Speciality speciality) {
        if (speciality == null) {
            notFound()
            return
        }

        try {
            specialityDataService.save(speciality)
        } catch (ValidationException e) {
            respond speciality.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'speciality.label', default: 'Speciality'), speciality.id])
                redirect speciality
            }
            '*'{ respond speciality, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        specialityDataService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'speciality.label', default: 'Speciality'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'speciality.label', default: 'Speciality'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
