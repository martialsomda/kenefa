package org.coders4africa.kenefa.domain.facility;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.coders4africa.kenefa.domain.ValueObject;
import org.coders4africa.kenefa.domain.facility.enums.Rate;

/**
 * Embedable Ratings.
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
@Embeddable
public class Ratings extends ValueObject {
    
    @Enumerated(EnumType.ORDINAL)
    private Rate overallQualityRate;
    @Enumerated(EnumType.ORDINAL)
    private Rate cleanlinessRate;
    @Enumerated(EnumType.ORDINAL)
    private Rate buildingRate;
    @Enumerated(EnumType.ORDINAL)
    private Rate equipmentRate;
            
    @Override
    public int hashCode() {
        int hash = 31;
        hash += getHashCode(overallQualityRate)*hash;
        hash += getHashCode(cleanlinessRate)*hash;
        hash += getHashCode(buildingRate)*hash;
        hash += getHashCode(equipmentRate)*hash;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Ratings)) {
            return false;
        }
        Ratings other = (Ratings) object;
        return areFieldsEquals(this.overallQualityRate, other.overallQualityRate)
                && areFieldsEquals(this.cleanlinessRate, other.cleanlinessRate)
                && areFieldsEquals(this.buildingRate, other.buildingRate)
                && areFieldsEquals(this.equipmentRate, other.equipmentRate);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Ratings")
                .append("[ overallQualityRate=").append(overallQualityRate)
                .append(", cleanlinessRate=").append(cleanlinessRate)
                .append(", buildingRate=").append(buildingRate)
                .append(", equipmentRate=").append(equipmentRate).append(" ]").toString();
    }
    
}
