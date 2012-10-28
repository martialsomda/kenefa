package org.coders4africa.kenefa.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Contry Entity
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
@Entity
@Table(name="countries")
@XmlRootElement
public class Country extends BaseEntity {

    private String name;
    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE} ,
            fetch= FetchType.EAGER,mappedBy="country")
    private Set<City> cities = new HashSet<City>();
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash += getHashCode(name)*hash;
        hash += getHashCode(cities)*hash;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        return areFieldsEquals(this.name,other.name)
                && areFieldsEquals(this.cities,other.cities);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Country#").append(getId())
                .append("[ name=").append(name).append(", cities=")
                .append(cities).append(" ]").toString();
    } 
}
