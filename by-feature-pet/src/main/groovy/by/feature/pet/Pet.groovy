package by.feature.pet

import grails.persistence.Entity

/**
 * Simple domain object representing a pet.
 *
 * @author Graeme Rocher
 */
@Entity
class Pet {

	String name
	Date birthDate
	PetType type
	Owner owner

	static hasMany = [visits: Visit]

	static constraints = {
		name blank: false, validator: { name, pet ->
			if (!pet.id && pet.owner?.pets?.find { it.name == name })  {
				return 'pet.duplicate'
			}
		}
	}
}
