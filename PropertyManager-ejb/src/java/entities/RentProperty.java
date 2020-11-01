/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author youcee
 */
@Entity
@DiscriminatorValue(value = "Rent")
public class RentProperty extends Property implements Serializable {

    private static final long serialVersionUID = 1L;
   
     @Column(name = "WEEKLY_RENT")
    private double weeklyRent;

    public double getWeeklyRent() {
        return weeklyRent;
    }

    public void setWeeklyRent(double weeklyRent) {
        this.weeklyRent = weeklyRent;
    }

    
    
}
