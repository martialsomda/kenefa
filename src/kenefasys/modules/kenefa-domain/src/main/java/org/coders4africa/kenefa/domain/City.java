package org.coders4africa.kenefa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * City entity
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
@Entity
@Table(name="cities")
@XmlRootElement
public class City extends BaseEntity {
    
    private String name;
    private String state;
    @ManyToOne(cascade=CascadeType.PERSIST,fetch= FetchType.EAGER)
    @JoinColumn(name="country",nullable=false)
    private Country country;
    
    @Override
    public int hashCode() {
        int hash = 11;
        hash += getHashCode(name)*hash;
        hash += getHashCode(state)*hash;
        hash += getHashCode(country)*hash;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        return areFieldsEquals(this.name,other.name)
                && areFieldsEquals(state,other.state)
                && areFieldsEquals(this.country,other.country);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("City#").append(getId())
                .append("[ name=").append(name).append(", state=").append(state)
                .append(", country=").append(country).append(" ]").toString();
    }  
}
