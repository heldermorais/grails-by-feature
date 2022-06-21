package by.feature.pet.owner

import by.feature.common.Persona
import by.feature.pet.animal.Pet
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
