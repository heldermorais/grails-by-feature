package by.feature.pet

import by.feature.common.CommonHexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*


@ByFeatureController
class PetTypeController extends CommonHexaController<PetType, PetTypeDataService>{


    PetTypeController(GrailsApplication grailsApplication, PetTypeDataService petTypeDataService) {
        super(grailsApplication, petTypeDataService)
    }


}
