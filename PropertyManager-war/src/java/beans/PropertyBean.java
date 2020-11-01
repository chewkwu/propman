/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.RentPropertyBean;
import business.SalePropertyBean;
import entities.RentProperty;
import entities.SaleProperty;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author youcee
 */
@ManagedBean(name = "propertyBean")
@RequestScoped
public class PropertyBean {
    
    private long id;
    private String address;
    private String type;
    private long managerID;
    private double salePrice;
    private String feedback;
    private double weeklyRental;
    
    @EJB
    SalePropertyBean salepropertybean;
    
    @EJB
    RentPropertyBean rentpropertybean;

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

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
    
     public double getWeeklyRental() {
        return weeklyRental;
    }

    public void setWeeklyRental(double weeklyRental) {
        this.weeklyRental = weeklyRental;
    }
    
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    public void createNewSaleProperty(){
        SaleProperty sale = new SaleProperty();
        sale.setAddress(getAddress());
        sale.setType("Sale");
        sale.setSalePrice(getSalePrice());
        long saleId = salepropertybean.createProperty(sale);
        if(saleId > 0){
            setFeedback("Property created Successfully with ID : " + saleId);
        }else{
            setFeedback("Failed to Create Property");
        }        
    }
    
    public void createNewRentProperty(){
        RentProperty rent = new RentProperty();
        rent.setAddress(getAddress());
        rent.setType("Rent");
        rent.setWeeklyRent(getWeeklyRental());
        long rentID = rentpropertybean.createProperty(rent);
        if(rentID > 0){
            setFeedback("Property created Successfully with ID : " + rentID);
        }else{
            setFeedback("Failed to Create Property");
        }    
    }
    
    public void deleteRentProperty(long id){
        try{
        rentpropertybean.deleteProperty(id);
        setFeedback("Rent Property Deleted");
        }catch(Exception e){
            setFeedback("Cant Find Property");
        }
    }
    
    public void deleteSaleProperty(){
        try{
        salepropertybean.deleteProperty(id);
        setFeedback("Sale Property Deleted");
        }catch(Exception e){
            setFeedback("Cant Find Property");
        }
    }
    
    public String findSale(){
        SaleProperty sale = salepropertybean.findSaleProperty(id);
        if(sale != null){
        setAddress(sale.getAddress());
        setType(sale.getType());
        setSalePrice(sale.getSalePrice());
            setFeedback("Property Found");
        return "sale";
        }else{
            setFeedback("No such Property");
            return "searchsale";
        }
    }
    
    public String findRent(){
        RentProperty rent = rentpropertybean.findRentProperty(id);
        if(rent != null){
            setAddress(rent.getAddress());
            setType(rent.getType());
            setWeeklyRental(rent.getWeeklyRent());
            return "rent";
        }else{
            setFeedback("No such Property");
            return "searchrent";
        }
    }
    
}
