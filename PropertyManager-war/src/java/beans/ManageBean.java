/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.ManagerBean;
import entities.Manager;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author youcee
 */
@ManagedBean(name = "manBean")
@RequestScoped
public class ManageBean {
    
    private long id;
    private String name;
    private String phone;
    private String address;
    private String feedback;
    
    @EJB
    ManagerBean managerbean;
    
    public void createManager(){
        Manager manager = new Manager();
        manager.setName(getName());
        manager.setPhone(getPhone());
        manager.setAddress(getAddress());
        long idM = managerbean.createManager(manager);
        if(idM > 0){
            setFeedback("Manager Created with ID : " + idM);
        }else{
            setFeedback("Failed to create Manager");
        }
    }

    public String findManager(){
        Manager manager = managerbean.findManager(id);
        if(manager != null){
            setId(manager.getId());
            setName(manager.getName());
            setPhone(manager.getPhone());
            setAddress(manager.getAddress());
            return "manager";
        }else{
            setFeedback("No such Manager");
            return "searchmanager";
        }
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
