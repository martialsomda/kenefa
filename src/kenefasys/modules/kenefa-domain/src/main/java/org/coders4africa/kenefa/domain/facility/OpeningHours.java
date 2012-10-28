package org.coders4africa.kenefa.domain.facility;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.coders4africa.kenefa.domain.BaseEntity;
import org.coders4africa.kenefa.domain.facility.enums.DaysOfWeek;

/**
 * Opening hours entity.
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
@Entity
@Table(name="openinghours")
@XmlRootElement
public class OpeningHours extends BaseEntity {
    
    @Enumerated(EnumType.STRING)
    private DaysOfWeek day;
    @Temporal(TemporalType.TIME)
    private Date start;
    @Temporal(TemporalType.TIME)
    private Date end;
    @ManyToOne(cascade= CascadeType.PERSIST,fetch= FetchType.EAGER)
    @JoinColumn(name="facilityID",nullable=false)
    private Facility facility;

    @Override
    public int hashCode() {
        int hash = 7;
        hash += getHashCode(day)*hash;
        hash += getHashCode(start)*hash;
        hash += getHashCode(end)*hash;
        hash += getHashCode(facility)*hash;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OpeningHours)) {
            return false;
        }
        OpeningHours other = (OpeningHours) object;
        return areFieldsEquals(this.day, other.day)
                && areFieldsEquals(this.start, other.start)
                && areFieldsEquals(this.end, other.end)
                && areFieldsEquals(this.facility, other.facility);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("OpeningHours#").append(getId())
                .append("[ day=").append(day).append(", from=").append(start)
                .append(", to=").append(end).append(", facility=").append(facility)
                .append(" ]").toString();
    }
    
}
