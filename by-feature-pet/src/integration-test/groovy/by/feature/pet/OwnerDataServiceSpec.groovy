package by.feature.pet

import by.feature.pet.owner.Owner
import by.feature.pet.owner.OwnerDataService
import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OwnerDataServiceSpec extends Specification {

    OwnerDataService ownerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Owner(...).save(flush: true, failOnError: true)
        //new Owner(...).save(flush: true, failOnError: true)
        //Owner owner = new Owner(...).save(flush: true, failOnError: true)
        //new Owner(...).save(flush: true, failOnError: true)
        //new Owner(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //owner.id
    }

    void "test get"() {
        setupData()

        expect:
        ownerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Owner> ownerList = ownerService.list(max: 2, offset: 2)

        then:
        ownerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ownerService.count() == 5
    }

    void "test delete"() {
        Long ownerId = setupData()

        expect:
        ownerService.count() == 5

        when:
        ownerService.delete(ownerId)
        sessionFactory.currentSession.flush()

        then:
        ownerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Owner owner = new Owner()
        ownerService.save(owner)

        then:
        owner.id != null
    }
}
