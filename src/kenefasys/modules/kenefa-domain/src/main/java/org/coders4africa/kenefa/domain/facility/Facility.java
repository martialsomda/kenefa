package org.coders4africa.kenefa.domain.facility;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.coders4africa.kenefa.domain.Address;
import org.coders4africa.kenefa.domain.BaseEntity;
import org.coders4africa.kenefa.domain.City;
import org.coders4africa.kenefa.domain.facility.enums.FacilityType;
import org.coders4africa.kenefa.domain.facility.enums.Scope;

/**
 * Facility entity
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
@Entity
@Table(name="facilities")
@XmlRootElement
public class Facility extends BaseEntity {
    
    private String name;
    @Enumerated(EnumType.STRING)
    private FacilityType facilityType;
    @Enumerated(EnumType.STRING)
    private Scope scope;
    @Embedded
    private Address address;
    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE},
            fetch= FetchType.LAZY,mappedBy="facility")
    private Set<Service> services = new HashSet<Service>();
    @Temporal(TemporalType.DATE)
    protected Date birthDayDate;
    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE} ,
            fetch= FetchType.LAZY,mappedBy="facility")
    private Set<OpeningHours> openingHours = new HashSet<OpeningHours>();
    @Embedded
    private Capacity capacity;
    @Embedded
    private Ratings rating;
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash += getHashCode(name)*hash;
        hash += getHashCode(facilityType)*hash;
        hash += getHashCode(scope)*hash;
        hash += getHashCode(address)*hash;
        hash += getHashCode(services)*hash;
        hash += getHashCode(birthDayDate)*hash;
        hash += getHashCode(openingHours)*hash;
        hash += getHashCode(capacity)*hash;
        hash += getHashCode(rating)*hash;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof City)) {
            return false;
        }
        Facility other = (Facility) object;
        return areFieldsEquals(this.name,other.name)
                && areFieldsEquals(this.facilityType,other.facilityType)
                && areFieldsEquals(this.scope,other.scope)
                && areFieldsEquals(this.address,other.address)
                && areFieldsEquals(this.services,other.services)
                && areFieldsEquals(this.birthDayDate,other.birthDayDate)
                && areFieldsEquals(this.openingHours, other.openingHours)
                && areFieldsEquals(this.capacity, other.capacity)
                && areFieldsEquals(this.rating, other.rating);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Facility#").append(getId())
                .append("[ name=").append(name).append(", facilityType=")
                .append(facilityType).append(", scope=").append(scope)
                .append(", address=").append(address).append(", birthDayDate=")
                .append(birthDayDate).append(", services=").append(services)
                .append(", openingHours=").append(openingHours)
                .append(", capacity=").append(capacity)
                .append(", rating=").append(rating).append(" ]").toString();
    }
    
}
