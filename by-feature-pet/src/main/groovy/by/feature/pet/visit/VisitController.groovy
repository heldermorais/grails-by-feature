package by.feature.pet.visit

import by.feature.common.CommonHexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication

@ByFeatureController
class VisitController extends CommonHexaController<Visit, VisitDataService>{


    VisitController(GrailsApplication grailsApplication, VisitDataService visitDataService) {
        super(grailsApplication, visitDataService)
    }


}
