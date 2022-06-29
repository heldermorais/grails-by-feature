package by.feature.person.speciality

import by.feature.common.HexaController
import by.feature.common.artefacts.ByFeatureController
import by.feature.common.gui.helpers.domain.DomainGuiRendererService
import by.feature.person.vet.Vet
import grails.core.GrailsApplication
import grails.web.servlet.mvc.GrailsParameterMap

@ByFeatureController
class SpecialityController extends HexaController<Speciality, SpecialityDataService> {


    SpecialityController(GrailsApplication grailsApplication, SpecialityDataService specialityDataService) {
        super(grailsApplication, specialityDataService)
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

    @Override
    def update(Long id) {
        return super.update(id)
    }


}
