package by.feature.person

import grails.persistence.Entity


@Entity
class Speciality {

    String name

    static constraints = {
        name blank: false, minSize: 3, maxSize: 20, unique: true
    }

}
