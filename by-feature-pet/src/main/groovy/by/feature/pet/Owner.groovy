package by.feature.pet

import by.feature.common.Persona
import grails.persistence.Entity



/**
 * Simple domain object representing an owner.
 *
 * @author Graeme Rocher
 */
@Entity
class Owner extends Persona {

	String address
	String city
	String telephone

	static hasMany = [pets: Pet]

	static constraints = {
		address blank: false
		city blank: false
		telephone matches: /\d+/, blank: false
	}
}
