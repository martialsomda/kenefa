package org.coders4africa.kenefa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Address entity.
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
@Embeddable
@XmlRootElement
public class Address extends ValueObject {
    
    private String street;
    @ManyToOne(cascade= CascadeType.PERSIST,fetch= FetchType.EAGER)
    @JoinColumn(name="city",nullable=false)
    private City city;
    private String zipCode;
    private String details;
    private String landPhone;
    private String webSite;
    private String email;

    @Override
    public int hashCode() {     
        int hash = 37;
        hash += getHashCode(street) * hash;
        hash += getHashCode(city) * hash;
        hash += getHashCode(zipCode) * hash;
        hash += getHashCode(details) * hash;
        hash += getHashCode(landPhone) * hash;
        hash += getHashCode(webSite) * hash;
        hash += getHashCode(email) * hash;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        return areFieldsEquals(street,other.street)
                && areFieldsEquals(city,other.city)
                && areFieldsEquals(zipCode,other.zipCode)
                && areFieldsEquals(details,other.details)
                && areFieldsEquals(landPhone,other.landPhone)
                && areFieldsEquals(webSite,other.webSite)
                && areFieldsEquals(email,other.email);
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append("Adresse")
                .append("[ street=").append(street).append(", zipCode=").append(zipCode)
                .append(", city=").append(city).append(", email=").append(email)
                .append(", landPhone=").append(landPhone)
                .append(", webSite=").append(webSite).append(" ]").toString();
    }
}
