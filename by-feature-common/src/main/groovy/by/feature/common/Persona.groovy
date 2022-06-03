package by.feature.common

import grails.persistence.Entity

/**
 * Simple domain object representing a person.
 *
 * @author Graeme Rocher
 */
abstract class Persona {

	String firstName
	String lastName

	static constraints = {
		firstName blank: false
		lastName blank: false
	}

}
