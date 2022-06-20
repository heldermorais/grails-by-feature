package by.feature.person.autorun

import grails.artefact.Artefact
import groovy.util.logging.Slf4j
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner


@Artefact("Service")
@Slf4j
class Person2AutorunService implements ApplicationRunner{

    Person2AutorunService(){
        log.info "Person2Autorun - CREATED"
    }


    @Override
    void run(ApplicationArguments args) throws Exception {
        log.warn "Person2Autorun.run - BEGIN"

        log.warn "Person2Autorun.run - END"
    }


}
