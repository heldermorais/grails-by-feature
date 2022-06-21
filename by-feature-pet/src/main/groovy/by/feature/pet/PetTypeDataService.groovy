package by.feature.pet

import grails.gorm.services.Service

@Service(PetType)
interface PetTypeDataService {

    PetType get(Serializable id)

    List<PetType> list(Map args)

    Long count()

    void delete(Serializable id)

    PetType save(PetType petType)

}