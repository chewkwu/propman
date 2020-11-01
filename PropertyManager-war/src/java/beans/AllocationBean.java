/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.RentPropertyBean;
import business.SalePropertyBean;
import entities.Manager;
import entities.RentProperty;
import entities.SaleProperty;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author youcee
 */
@ManagedBean(name = "allocationBean")
@RequestScoped
public class AllocationBean {
    
    private long id;
    private String address;
    private String type;
    private long managerID;
    private double payment;
    private String feedback;
   
    @EJB
    RentPropertyBean rentPropertyBean;
    
    @EJB
    SalePropertyBean salePropertyBean;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getManagerID() {
        return managerID;
    }

    public void setManagerID(long managerID) {
        this.managerID = managerID;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    public String findAllocation(){
        if(type.equalsIgnoreCase("Rent")){
            RentProperty rent = rentPropertyBean.findRentProperty(id);
            if(rent != null){
                setId(rent.getId());
                setAddress(rent.getAddress());
                setManagerID(rent.getManager().getId());
                setType(rent.getType());
                setPayment(rent.getWeeklyRent());
                return "allocation";
            }else{
                setFeedback("No such Allocation");
                return "searchallocation";
            }
        }else if(type.equalsIgnoreCase("Sale")){
            SaleProperty sale = salePropertyBean.findSaleProperty(id);
            if(sale != null){
                setId(sale.getId());
                setAddress(sale.getAddress());
                setManagerID(sale.getManager().getId());
                setType(sale.getType());
                setPayment(sale.getSalePrice());
                return "allocation";
            }else{
                setFeedback("No such Allocation");
                return "findAllocation";
            }
        }else{
            setFeedback("Invalid Type Field, Rent or sale");
                return "findAllocation";
        }
    }
    public void createAllocation(){
        Manager manager = new Manager();
        manager.setId(managerID);
        if(type.equalsIgnoreCase("Rent")){
            RentProperty rent = new RentProperty();
            rent.setId(id);
            rent.setType(type);
            rent.setManager(manager);
            rentPropertyBean.allocateRental(rent);
            setFeedback("Allocation Done");
        }else if(type.equalsIgnoreCase("Sale")){
            SaleProperty sale = new SaleProperty();
            sale.setId(id);
            sale.setType(type);
            sale.setManager(manager);
            salePropertyBean.allocateSale(sale);
            setFeedback("Allocation Done");
        }else{
            setFeedback("Invalid Type Field, Rent or Sale");
        }
    }
    
}
