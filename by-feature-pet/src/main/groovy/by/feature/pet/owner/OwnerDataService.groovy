package by.feature.pet.owner

import grails.gorm.services.Service

@Service(Owner)
interface OwnerDataService {

    Owner get(Serializable id)

    List<Owner> list(Map args)

    Long count()

    void delete(Serializable id)

    Owner save(Owner owner)

}