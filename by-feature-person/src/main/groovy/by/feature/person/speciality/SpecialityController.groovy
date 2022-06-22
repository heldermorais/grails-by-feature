package by.feature.person.speciality

import by.feature.common.CommonHexaController
import by.feature.common.artefacts.ByFeatureController
import by.feature.common.gui.helpers.domain.DomainGuiRendererService
import by.feature.person.vet.Vet
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


    DomainGuiRendererService domainGuiRendererService

    @Override
    def index(Integer max) {

        domainGuiRendererService.renderDomainAsForm( new Vet() )

        return super.index(max)
    }

    def hello(){
        respond view:'hello'
    }


}
