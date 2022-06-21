package by.feature.pet

import by.feature.common.CommonHexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication
import grails.validation.ValidationException
import grails.web.Controller

import static org.springframework.http.HttpStatus.*

@ByFeatureController
class OwnerController extends CommonHexaController<Owner, OwnerDataService>{

    OwnerController(GrailsApplication grailsApplication, OwnerDataService ownerDataService) {
        super(grailsApplication, ownerDataService)
    }

}
