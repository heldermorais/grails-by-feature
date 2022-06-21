package by.feature.person.autorun

import by.feature.common.artefacts.ByFeatureService
import by.feature.person.speciality.Speciality
import by.feature.person.vet.Vet
import grails.gorm.transactions.Transactional
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner


@ByFeatureService
class PetInitDBService implements ApplicationRunner {

    PetInitDBService(){
        log.info " .. PersonAutorunService - CREATED"
    }

    @Override
    void run(ApplicationArguments args) throws Exception {
        log.debug "PersonAutorunService - BEGIN"
        initSpeciality()
        initVet()
        log.debug "PersonAutorunService - END"
    }


    @Transactional
    protected void initVet() {
        log.warn "Init DB to [Vet] ..."
        Vet vet = new Vet(firstName: "James", lastName: "Carter")
        vet.save()

        vet = new Vet(firstName: "Helen", lastName: "Leary")
        vet.addToSpecialities(Speciality.get(1))
        vet.save()

        vet = new Vet(firstName: "Linda", lastName: "Douglas")
        vet.addToSpecialities(Speciality.get(2))
        vet.addToSpecialities(Speciality.get(3))
        vet.save()

        vet = new Vet(firstName: "Rafael", lastName: "Ortega")
        vet.addToSpecialities(Speciality.get(2))
        vet.save()

        vet = new Vet(firstName: "Henry", lastName: "Stevens")
        vet.addToSpecialities(Speciality.get(1))
        vet.save()

        vet = new Vet(firstName: "Sharon", lastName: "Jenkins")
        vet.save()
    }

    @Transactional
    protected void initSpeciality() {
        log.warn "Init DB to [Speciality] ..."
        Speciality speciality = new Speciality(name: "radiology")
        speciality.save()

        speciality = new Speciality(name: "surgery")
        speciality.save()

        speciality = new Speciality(name: "dentistry")
        speciality.save()
    }

}
