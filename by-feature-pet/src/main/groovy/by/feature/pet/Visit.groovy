package by.feature.pet

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
