package by.feature.person

import grails.gorm.services.Service

@Service(Speciality)
interface SpecialityService {

    Speciality get(Serializable id)

    List<Speciality> list(Map args)

    Long count()

    void delete(Serializable id)

    Speciality save(Speciality speciality)

}