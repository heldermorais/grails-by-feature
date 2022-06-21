package by.feature.pet

import by.feature.common.CommonHexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*


@ByFeatureController
class PetController extends CommonHexaController<Pet, PetDataService>{


    PetController(GrailsApplication grailsApplication, PetDataService petDataService) {
        super(grailsApplication, petDataService)
    }


}
