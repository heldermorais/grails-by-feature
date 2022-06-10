package by.feature

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.context.annotation.ComponentScan

@CompileStatic
@Slf4j
class Application extends GrailsAutoConfiguration {

    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }


//    @Override
//    Collection<String> packageNames() {
//        log.debug "... packageNames() = ${super.packageNames() + ['by.feature.common', 'by.feature.person', 'by.feature.pet']}"
//        return super.packageNames() + ['by.feature.common', 'by.feature.person', 'by.feature.pet']
//    }
//


    @Override
    protected boolean limitScanningToApplication() {
        return false
    }

}