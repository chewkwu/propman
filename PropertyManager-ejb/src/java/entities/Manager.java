/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author youcee
 */
@Entity
@Table(name = "MANAGER_TABLE")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MANAGER_ID")
    private Long id;
    @Column(name = "MANAGER_NAME")
    private String name;
    @Column(name = "MANAGER_PHONE")
    private String phone;
    @Column(name = "MANAGER_ADDRESS")
    private String Address;
    @OneToMany(targetEntity = Property.class, mappedBy = "manager")
    private Collection properties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Collection getProperties() {
        return properties;
    }

    public void setProperties(Collection properties) {
        this.properties = properties;
    }
    
}
