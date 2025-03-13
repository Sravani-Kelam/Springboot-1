package com.product.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name="product")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private float netquantity;

    public ProductEntity(int id, String name, double price, float netquantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.netquantity = netquantity;
    }
     public ProductEntity(){
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id == that.id && Double.compare(price, that.price) == 0 && Float.compare(netquantity, that.netquantity) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, netquantity);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", netquantity=" + netquantity +
                '}';
    }
}
