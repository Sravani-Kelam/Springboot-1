package com.pro.jpa4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private Integer empId;
    private String empName;
    private String empLoc;
    private Double empSal;
    //generate constructors etc..


    public Employee() {
    }

    public Employee(Integer empId) {
        this.empId = empId;
    }

    public Employee(Integer empId, String empName, String empLoc, Double empSal) {
        this.empId = empId;
        this.empName = empName;
        this.empLoc = empLoc;
        this.empSal = empSal;
    }

    public Employee(Double empSal, String empLoc, String empName) {
        this.empSal = empSal;
        this.empLoc = empLoc;
        this.empName = empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpLoc() {
        return empLoc;
    }

    public void setEmpLoc(String empLoc) {
        this.empLoc = empLoc;
    }

    public Double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empLoc='" + empLoc + '\'' +
                ", empSal=" + empSal +
                '}';
    }
}