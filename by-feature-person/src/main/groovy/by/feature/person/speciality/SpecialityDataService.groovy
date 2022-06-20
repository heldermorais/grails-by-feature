package by.feature.person.speciality

import grails.gorm.services.Service

@Service(Speciality)
interface SpecialityDataService {

    Speciality get(Serializable id)

    List<Speciality> list(Map args)

    Long count()

    void delete(Serializable id)

    Speciality save(Speciality speciality)

}