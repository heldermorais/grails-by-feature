package by.feature.person.speciality

import grails.artefact.Artefact
import grails.databinding.BindUsing
import grails.persistence.Entity



@Entity
class Speciality {

    String     name

    Date publishedDate

    @BindUsing({
        obj, source -> new BigDecimal(source['salary'])
    })
    BigDecimal salary

    String     email

    Integer    awards


    static constraints = {
        name blank: false, minSize: 3, maxSize: 20, unique: true
        publishedDate nullable: true
        salary        nullable: true, scale: 2, min: new BigDecimal(0)
        email         nullable: true, email: true
        awards        nullable: true
    }


    @Override
    String toString() {
        return "(${this.id}) - ${name}"
    }

}
