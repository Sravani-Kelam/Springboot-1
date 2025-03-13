package com.company.demo.dto;


public class CompanyDto {
    private long id;
    private String department;
    private double networth;

    public CompanyDto() {
        super();
    }

    public CompanyDto(long id, String department, double networth) {
        this.id = id;
        this.department = department;
        this.networth = networth;
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
}
