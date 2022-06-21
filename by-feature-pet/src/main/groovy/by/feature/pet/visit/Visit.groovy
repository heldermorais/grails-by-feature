package by.feature.pet.visit

import by.feature.pet.animal.Pet
import grails.persistence.Entity

/**
 * Simple domain object representing a visit.
 *
 * @author Graeme Rocher
 */
@Entity
class Visit {

	Date date = new Date()
	String description
    Pet pet

	static constraints = {
		description blank:false
	}
}
