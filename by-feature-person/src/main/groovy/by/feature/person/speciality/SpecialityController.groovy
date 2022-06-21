package by.feature.person.speciality

import by.feature.common.CommonHexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication
import grails.validation.ValidationException
import grails.web.Controller
import grails.web.servlet.mvc.GrailsParameterMap

import static org.springframework.http.HttpStatus.*

@ByFeatureController
class SpecialityController extends CommonHexaController<Speciality, SpecialityDataService> {


    SpecialityController(GrailsApplication grailsApplication, SpecialityDataService specialityDataService) {
        super(grailsApplication, specialityDataService)
        //grailsApplication.getMainContext().getBeanDefinitionNames()
    }


    def hello(){
        respond view:'hello'
    }


}
