/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.RentProperty;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author youcee
 */
@Stateless
@LocalBean
public class RentPropertyBean {
    
    @PersistenceContext(unitName="PropertyManager-ejbPU")
    EntityManager em;

    public long createProperty(RentProperty property){
        em.persist(property);
        em.flush();
        return property.getId();
    }

    public RentProperty findRentProperty(long id){
        return em.find(RentProperty.class, id);
    }
    
    public List<RentProperty> allRentProperties(){
        Query query = em.createQuery("SELECT e FROM RentProperty e");
          return (List<RentProperty>) query.getResultList();
    }

    public void deleteProperty(long id){
        em.remove(em.find(RentProperty.class, id));
    }
    
    public void allocateRental(RentProperty rt){
        RentProperty rent = em.find(RentProperty.class, rt.getId());
        rent.setManager(rt.getManager());
        em.persist(rent);
    }
    
}
