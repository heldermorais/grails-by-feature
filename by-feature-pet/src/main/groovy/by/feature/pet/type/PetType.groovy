package by.feature.pet.type

import grails.persistence.Entity

/**
 * @author Graeme Rocher
 */
@Entity
class PetType {
	
	String name
	
	static constraints = {
		name blank: false, minSize: 3, maxSize: 20, unique: true , gui:{ placeholder: "Digite a Espécie do pet" }
	}
}
