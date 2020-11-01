/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.RentProperty;
import entities.SaleProperty;
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
public class SalePropertyBean {
    
    @PersistenceContext(unitName="PropertyManager-ejbPU")
    EntityManager em;

    public long createProperty(SaleProperty property){
        em.persist(property);
        em.flush();
        return property.getId();
    }

    public SaleProperty findSaleProperty(long id){
        return em.find(SaleProperty.class, id);
    }
    
    public List<SaleProperty> allSaleProperties(){
        Query query = em.createQuery("SELECT e FROM SaleProperty e");
          return (List<SaleProperty>) query.getResultList();
    }

    public void deleteProperty(long id){
        em.remove(em.find(SaleProperty.class, id));
    }
    
     public void allocateSale(SaleProperty st){
        SaleProperty sale = em.find(SaleProperty.class, st.getId());
        sale.setManager(st.getManager());
        em.persist(sale);
    }
    
}
