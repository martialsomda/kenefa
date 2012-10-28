package org.coders4africa.kenefa.domain.facility;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.coders4africa.kenefa.domain.BaseEntity;
import org.coders4africa.kenefa.domain.facility.enums.ServiceType;

/**
 * Service Entity
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
@Entity
@Table(name="services")
@XmlRootElement
public class Service extends BaseEntity {
    
    @Enumerated(EnumType.STRING)
    private ServiceType name;
    @ManyToOne(cascade= CascadeType.PERSIST,fetch= FetchType.EAGER)
    @JoinColumn(name="facilityID",nullable=false)
    private Facility facility;
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash += getHashCode(name)*hash;
        hash += getHashCode(facility)*hash;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        return areFieldsEquals(this.name, other.name)
                && areFieldsEquals(this.facility, other.facility);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Service#").append(getId())
                .append("[ name=").append(name).append(", facility=").append(facility)
                .append(" ]").toString();
    }
    
}
