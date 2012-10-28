package org.coders4africa.kenefa.facade;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MSOMDA
 */
@Stateless
@LocalBean
public class TestEJB {

    @PersistenceContext
    private EntityManager entityManager;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void businessMethod() {
    }
    
}
