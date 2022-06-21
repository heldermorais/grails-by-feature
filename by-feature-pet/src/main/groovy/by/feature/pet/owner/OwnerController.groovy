package by.feature.pet.owner

import by.feature.common.CommonHexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication

@ByFeatureController
class OwnerController extends CommonHexaController<Owner, OwnerDataService>{

    OwnerController(GrailsApplication grailsApplication, OwnerDataService ownerDataService) {
        super(grailsApplication, ownerDataService)
    }

}
