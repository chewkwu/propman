/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Manager;
import java.util.Collection;
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
public class ManagerBean {

    @PersistenceContext(unitName="PropertyManager-ejbPU")
    EntityManager em;
    
    public long createManager(Manager manager){
        em.persist(manager);
        em.flush();
        return manager.getId();
    }
    
    public Manager findManager(long id){
        return em.find(Manager.class, id);
    }
    
    public List<Manager> allManagers(){
        Query query = em.createQuery("SELECT e FROM Manager e");
        return (List<Manager>) query.getResultList();
    }
    
    public void removeManager(long id){
        em.remove(em.find(Manager.class, id));
    }
    
    public Collection allMangedProperties(long id){
         return em.find(Manager.class, id).getProperties();
    }
    
}
