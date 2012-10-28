package org.coders4africa.kenefa.domain;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
@MappedSuperclass
public class ValueObject implements Serializable {
    
    /**
     * Tests 2 fields equality
     * 
     * @return 'True' if fileds are equal
     *         'False' if not.
     */
    protected static <T> boolean areFieldsEquals(T field, T otherField){
        return field == null ? otherField == null : field.equals(otherField);
    }
    
    protected static <T> int getHashCode(T object){
        return object == null ? 1 : object.hashCode();
    }
}
