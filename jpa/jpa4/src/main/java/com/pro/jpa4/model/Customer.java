package com.pro.jpa4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer_tab")
public class Customer {
    @Id
    private Integer custId;
    private String custName;
    private String custLoc;
    public Customer();

    public Customer(Integer custId) {
        this.custId = custId;
    }

    public Customer( String custName, String custLoc) {
        this.custName = custName;
        this.custLoc = custLoc;
    }
    public Customer(Integer custId, String custName, String custLoc) {
        this.custId = custId;
        this.custName = custName;
        this.custLoc = custLoc;
    }
}
