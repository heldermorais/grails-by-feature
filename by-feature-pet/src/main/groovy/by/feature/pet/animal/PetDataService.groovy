package by.feature.pet.animal

import grails.gorm.services.Service

@Service(Pet)
interface PetDataService {

    Pet get(Serializable id)

    List<Pet> list(Map args)

    Long count()

    void delete(Serializable id)

    Pet save(Pet pet)

}