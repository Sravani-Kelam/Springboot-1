package com.company.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Objects;

@Entity
@Table(name="Department")

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String department;
    private double networth;

    public Company(long id, String department, double networth) {
        this.id = id;
        this.department = department;
        this.networth = networth;
    }

    public Company(){
            super();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getNetworth() {
        return networth;
    }

    public void setNetworth(double networth) {
        this.networth = networth;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && Double.compare(networth, company.networth) == 0 && Objects.equals(department, company.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, networth);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", networth=" + networth +
                '}';
    }
}
