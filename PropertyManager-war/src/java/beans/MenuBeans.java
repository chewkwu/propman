/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.ManagerBean;
import business.RentPropertyBean;
import business.SalePropertyBean;
import entities.Manager;
import entities.RentProperty;
import entities.SaleProperty;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author youcee
 */
@ManagedBean(name = "menuBeans")
@RequestScoped
public class MenuBeans {
    
    private List<RentProperty> allRentals = new ArrayList<>();
    private List<SaleProperty> allSalesProps = new ArrayList<>();
    private List<Manager> allManagers = new ArrayList<>();
    private List<AllocationBean> allAllocations = new ArrayList<>();
    
    @EJB
    SalePropertyBean salepropertybean;
    
    @EJB
    RentPropertyBean rentpropertybean;
    
    @EJB
    ManagerBean managerbean;
   
     public String allRentProperties(){
        List<RentProperty> allRents = (List<RentProperty>)rentpropertybean.allRentProperties();
         setAllRentals(allRents);
        return "allrent";
    }

     public String allSaleProps(){
         List<SaleProperty> allSales = (List<SaleProperty>)salepropertybean.allSaleProperties();
         setAllSalesProps(allSales);
         return "allsale";
     }
     
    public List<RentProperty> getAllRentals() {
        return allRentals;
    }

    public void setAllRentals(List<RentProperty> allRentals) {
        this.allRentals = allRentals;
    }

    public List<SaleProperty> getAllSalesProps() {
        return allSalesProps;
    }

    public void setAllSalesProps(List<SaleProperty> allSales) {
        this.allSalesProps = allSales;
    }

    public List<Manager> getAllManagers() {
        return allManagers;
    }

    public void setAllManagers(List<Manager> allManagers) {
        this.allManagers = allManagers;
    }
    
     public List<AllocationBean> getAllAllocations() {
        return allAllocations;
    }

    public void setAllAllocations(List<AllocationBean> allAllocations) {
        this.allAllocations = allAllocations;
    }
    
    public String allManager(){
        List<Manager> allM = (List<Manager>)managerbean.allManagers();
        setAllManagers(allM);
        return "allmanager";
    }
    public String allAllocation(){
        List<RentProperty> allRents = rentpropertybean.allRentProperties();
        for(RentProperty rt: allRents){
            if(rt.getManager() != null){
                AllocationBean allocation = new AllocationBean();
                allocation.setId(rt.getId());
                allocation.setAddress(rt.getAddress());
                allocation.setManagerID(rt.getManager().getId());
                allocation.setType(rt.getType());
                allocation.setPayment(rt.getWeeklyRent());
                allAllocations.add(allocation);
            }
        }
        List<SaleProperty> allSales = salepropertybean.allSaleProperties();
        for(SaleProperty sale: allSales){
            if(sale.getManager() != null){
                AllocationBean allocation = new AllocationBean();
                allocation.setId(sale.getId());
                allocation.setAddress(sale.getAddress());
                allocation.setManagerID(sale.getManager().getId());
                allocation.setType(sale.getType());
                allocation.setPayment(sale.getSalePrice());
                allAllocations.add(allocation);
            }
        }
        return "allallocations";
    }
}
