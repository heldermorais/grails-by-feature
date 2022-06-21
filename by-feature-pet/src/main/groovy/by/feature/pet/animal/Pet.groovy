package by.feature.pet.animal

import by.feature.pet.owner.Owner
import by.feature.pet.type.PetType
import by.feature.pet.visit.Visit
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
