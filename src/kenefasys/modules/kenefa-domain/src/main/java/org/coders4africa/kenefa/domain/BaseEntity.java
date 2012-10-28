package org.coders4africa.kenefa.domain;

import javax.persistence.GenerationType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.coders4africa.kenefa.jaxb.IDAdapter;
import static org.coders4africa.kenefa.jpa.JPAUtils.implementationClass;

/**
 * This class is the base class for all entities.<br/>
 * This class introduce a hierarchy that permit to apply
 * common rules on uppon entities regardless of their real type.<br/>
 * For exemple with that we can simply search an entity based on
 * its identifier. The real entity type will be determined at run-time
 * to find the table to search into.
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
@MappedSuperclass
public abstract class BaseEntity extends ValueObject {
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Transient
    private final Class<? extends BaseEntity> entityClass;

    protected BaseEntity() {
        entityClass = implementationClass(getClass());
    }
     
    
    /**
     * This Getter/Setter
     * The @XmlID is necessary to be referenced by
     * @XmlIDREF Attribute
     */
    @XmlID
    @XmlAttribute
    @XmlJavaTypeAdapter(IDAdapter.class)
    public Long getId() {
        return id;
    }

    /**
     * Set the value of unique identfier of the entity
     *
     * @param id new value of the unique identfier
     */
    public void setId(Long id) {
        this.id = id;
    }
}
