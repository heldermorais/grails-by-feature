package by.feature.pet.owner

import by.feature.common.HexaController
import by.feature.common.artefacts.ByFeatureController
import grails.core.GrailsApplication

@ByFeatureController
class OwnerController extends HexaController<Owner, OwnerDataService>{

    OwnerController(GrailsApplication grailsApplication, OwnerDataService ownerDataService) {
        super(grailsApplication, ownerDataService)
    }

}
