package by.feature.person.autorun

import grails.artefact.Artefact
import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner

@Artefact("Service")
@Slf4j
class PersonAutorunService implements ApplicationRunner {


    PersonAutorunService(){
        log.info " .. PersonAutorunService - CREATED"
    }

    @Override
    void run(ApplicationArguments args) throws Exception {
        log.warn " ...PersonAutorunService.run(...) - BEGIN"

        log.warn " ...PersonAutorunService.run(...) - END"
    }
}
