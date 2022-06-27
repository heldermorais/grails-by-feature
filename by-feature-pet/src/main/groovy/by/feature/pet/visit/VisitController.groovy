package by.feature.pet.visit

import by.feature.common.HexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication

@ByFeatureController
class VisitController extends HexaController<Visit, VisitDataService>{


    VisitController(GrailsApplication grailsApplication, VisitDataService visitDataService) {
        super(grailsApplication, visitDataService)
    }


}
