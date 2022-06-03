package by.feature.pet

import grails.gorm.services.Service

@Service(Visit)
interface VisitService {

    Visit get(Serializable id)

    List<Visit> list(Map args)

    Long count()

    void delete(Serializable id)

    Visit save(Visit visit)

}