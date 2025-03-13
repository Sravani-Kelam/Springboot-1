package com.product.demo.dto;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private float netquantity;

    public ProductDto(int id, String name, double price, float netquantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.netquantity = netquantity;
    }
    public ProductDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getNetquantity() {
        return netquantity;
    }

    public void setNetquantity(float netquantity) {
        this.netquantity = netquantity;
    }
}
