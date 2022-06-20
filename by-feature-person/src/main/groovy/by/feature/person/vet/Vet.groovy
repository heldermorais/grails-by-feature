package by.feature.person.vet

import by.feature.common.Persona
import by.feature.person.speciality.Speciality
import grails.persistence.Entity


@Entity
class Vet extends Persona {


    static hasMany = [specialities: Speciality]


    static constraints = {
        firstName nullable: false, blank: false, minSize: 4
        lastName blank: false, nullable: false, minSize: 4
    }

}
