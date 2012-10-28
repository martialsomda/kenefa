package org.coders4africa.kenefa.domain.facility;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;
import org.coders4africa.kenefa.domain.ValueObject;

/**
 * Embadable Capacity.
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
@Embeddable
@XmlRootElement
public class Capacity extends ValueObject {
   
    private Integer availableBeds;
    private Integer workingDoctors;
    private Integer workingNurses;

    @Override
    public int hashCode() {
        int hash = 13;
        hash += getHashCode(availableBeds)*hash;
        hash += getHashCode(workingDoctors)*hash;
        hash += getHashCode(workingNurses)*hash;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Capacity)) {
            return false;
        }
        Capacity other = (Capacity) object;
        return areFieldsEquals(this.availableBeds, other.availableBeds)
                && areFieldsEquals(this.workingDoctors, other.workingDoctors)
                && areFieldsEquals(this.workingNurses, other.workingNurses);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Capacity")
                .append("[ availableBeds=").append(availableBeds)
                .append(", workingDoctors=").append(workingDoctors)
                .append(", workingNurses=").append(workingNurses).append(" ]").toString();
    }
    
}
