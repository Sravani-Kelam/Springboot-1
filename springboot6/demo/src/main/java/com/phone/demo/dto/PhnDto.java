package com.phone.demo.dto;

import jakarta.persistence.Entity;
import lombok.Data;
@Data
public class PhnDto {
    private long phnnum;
    private String brand;
    private double price;

    public PhnDto(long phnnum, String brand, double price) {
        this.phnnum = phnnum;
        this.brand = brand;
        this.price = price;
    }
    public PhnDto(){
        super();
    }

    public long getPhnnum() {
        return phnnum;
    }

    public void setPhnnum(long phnnum) {
        this.phnnum = phnnum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
