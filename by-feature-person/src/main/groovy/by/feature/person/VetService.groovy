package by.feature.person

import grails.gorm.services.Service

@Service(Vet)
interface VetService {

    Vet get(Serializable id)

    List<Vet> list(Map args)

    Long count()

    void delete(Serializable id)

    Vet save(Vet vet)

}