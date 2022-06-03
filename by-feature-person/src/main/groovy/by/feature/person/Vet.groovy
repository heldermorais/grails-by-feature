package by.feature.person

import by.feature.common.Persona
import grails.persistence.Entity


@Entity
class Vet extends Persona {


    static hasMany = [specialities: Speciality]

}
