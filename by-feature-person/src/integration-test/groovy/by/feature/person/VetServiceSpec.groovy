package by.feature.person

import by.feature.person.vet.Vet
import by.feature.person.vet.VetService
import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VetServiceSpec extends Specification {

    VetService vetService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vet(...).save(flush: true, failOnError: true)
        //new Vet(...).save(flush: true, failOnError: true)
        //Vet vet = new Vet(...).save(flush: true, failOnError: true)
        //new Vet(...).save(flush: true, failOnError: true)
        //new Vet(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vet.id
    }

    void "test get"() {
        setupData()

        expect:
        vetService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vet> vetList = vetService.list(max: 2, offset: 2)

        then:
        vetList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vetService.count() == 5
    }

    void "test delete"() {
        Long vetId = setupData()

        expect:
        vetService.count() == 5

        when:
        vetService.delete(vetId)
        sessionFactory.currentSession.flush()

        then:
        vetService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vet vet = new Vet()
        vetService.save(vet)

        then:
        vet.id != null
    }
}
