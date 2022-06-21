package by.feature.pet.autorun

import grails.artefact.Artefact
import groovy.util.logging.Slf4j
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Service

@Slf4j
@Artefact("Service")
class PetAutorunService implements ApplicationRunner {


    PetAutorunService(){
        log.debug "PetAutorun - CREATED"
    }



    @Override
    void run(ApplicationArguments args) throws Exception {
        log.debug "PetAutorun - BEGIN"
        Thread.sleep(1000)
        log.debug "PetAutorun - END"
    }


}
