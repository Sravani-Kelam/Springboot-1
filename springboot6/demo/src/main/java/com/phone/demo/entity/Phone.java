package com.phone.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name="Phns")
@Data
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long phnnum;
    private String brand;
    private double price;

    public Phone(long phnnum, String brand, double price) {
        this.phnnum = phnnum;
        this.brand = brand;
        this.price = price;
    }
    public Phone(){
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return phnnum == phone.phnnum && Double.compare(price, phone.price) == 0 && Objects.equals(brand, phone.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phnnum, brand, price);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phnnum=" + phnnum +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
