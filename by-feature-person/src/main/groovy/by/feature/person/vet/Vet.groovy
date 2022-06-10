package by.feature.person.vet

import by.feature.common.Persona
import by.feature.person.speciality.Speciality
import grails.persistence.Entity


@Entity
class Vet extends Persona {


    static hasMany = [specialities: Speciality]

}
