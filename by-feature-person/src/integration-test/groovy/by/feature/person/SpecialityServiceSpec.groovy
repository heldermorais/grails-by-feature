package by.feature.person

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SpecialityServiceSpec extends Specification {

    SpecialityService specialityService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Speciality(...).save(flush: true, failOnError: true)
        //new Speciality(...).save(flush: true, failOnError: true)
        //Speciality speciality = new Speciality(...).save(flush: true, failOnError: true)
        //new Speciality(...).save(flush: true, failOnError: true)
        //new Speciality(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //speciality.id
    }

    void "test get"() {
        setupData()

        expect:
        specialityService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Speciality> specialityList = specialityService.list(max: 2, offset: 2)

        then:
        specialityList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        specialityService.count() == 5
    }

    void "test delete"() {
        Long specialityId = setupData()

        expect:
        specialityService.count() == 5

        when:
        specialityService.delete(specialityId)
        sessionFactory.currentSession.flush()

        then:
        specialityService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Speciality speciality = new Speciality()
        specialityService.save(speciality)

        then:
        speciality.id != null
    }
}
