package by.feature.pet.type

import by.feature.common.CommonHexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication

@ByFeatureController
class PetTypeController extends CommonHexaController<PetType, PetTypeDataService>{


    PetTypeController(GrailsApplication grailsApplication, PetTypeDataService petTypeDataService) {
        super(grailsApplication, petTypeDataService)
    }


}
