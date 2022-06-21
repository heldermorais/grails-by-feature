package by.feature.pet.animal

import by.feature.common.CommonHexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication

@ByFeatureController
class PetController extends CommonHexaController<Pet, PetDataService>{


    PetController(GrailsApplication grailsApplication, PetDataService petDataService) {
        super(grailsApplication, petDataService)
    }


}
