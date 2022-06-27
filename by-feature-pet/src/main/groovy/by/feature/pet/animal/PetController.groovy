package by.feature.pet.animal

import by.feature.common.HexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication

@ByFeatureController
class PetController extends HexaController<Pet, PetDataService>{


    PetController(GrailsApplication grailsApplication, PetDataService petDataService) {
        super(grailsApplication, petDataService)
    }


}
