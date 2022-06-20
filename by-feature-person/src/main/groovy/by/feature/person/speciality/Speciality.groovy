package by.feature.person.speciality

import grails.artefact.Artefact
import grails.persistence.Entity


@Entity
class Speciality {

    String name

    static constraints = {
        name blank: false, minSize: 3, maxSize: 20, unique: true
    }

}
