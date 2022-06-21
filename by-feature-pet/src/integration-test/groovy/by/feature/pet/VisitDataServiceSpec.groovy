package by.feature.pet

import by.feature.pet.visit.Visit
import by.feature.pet.visit.VisitDataService
import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VisitDataServiceSpec extends Specification {

    VisitDataService visitService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Visit(...).save(flush: true, failOnError: true)
        //new Visit(...).save(flush: true, failOnError: true)
        //Visit visit = new Visit(...).save(flush: true, failOnError: true)
        //new Visit(...).save(flush: true, failOnError: true)
        //new Visit(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //visit.id
    }

    void "test get"() {
        setupData()

        expect:
        visitService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Visit> visitList = visitService.list(max: 2, offset: 2)

        then:
        visitList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        visitService.count() == 5
    }

    void "test delete"() {
        Long visitId = setupData()

        expect:
        visitService.count() == 5

        when:
        visitService.delete(visitId)
        sessionFactory.currentSession.flush()

        then:
        visitService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Visit visit = new Visit()
        visitService.save(visit)

        then:
        visit.id != null
    }
}
