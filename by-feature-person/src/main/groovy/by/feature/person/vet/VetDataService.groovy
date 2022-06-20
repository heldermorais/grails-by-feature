package by.feature.person.vet

import grails.gorm.services.Service

@Service(Vet)
interface VetDataService {

    Vet get(Serializable id)

    List<Vet> list(Map args)

    Long count()

    void delete(Serializable id)

    Vet save(Vet vet)

}