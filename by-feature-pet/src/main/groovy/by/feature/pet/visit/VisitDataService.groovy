package by.feature.pet.visit

import grails.gorm.services.Service

@Service(Visit)
interface VisitDataService {

    Visit get(Serializable id)

    List<Visit> list(Map args)

    Long count()

    void delete(Serializable id)

    Visit save(Visit visit)

}