package by.feature.pet

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PetTypeServiceSpec extends Specification {

    PetTypeService petTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PetType(...).save(flush: true, failOnError: true)
        //new PetType(...).save(flush: true, failOnError: true)
        //PetType petType = new PetType(...).save(flush: true, failOnError: true)
        //new PetType(...).save(flush: true, failOnError: true)
        //new PetType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //petType.id
    }

    void "test get"() {
        setupData()

        expect:
        petTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PetType> petTypeList = petTypeService.list(max: 2, offset: 2)

        then:
        petTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        petTypeService.count() == 5
    }

    void "test delete"() {
        Long petTypeId = setupData()

        expect:
        petTypeService.count() == 5

        when:
        petTypeService.delete(petTypeId)
        sessionFactory.currentSession.flush()

        then:
        petTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PetType petType = new PetType()
        petTypeService.save(petType)

        then:
        petType.id != null
    }
}
