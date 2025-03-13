package com.hotel.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.util.Objects;

@Entity
@Table(name = "hotel")
@Data
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double money;
    @Lob
    private byte[] photo;

    public HotelEntity(int id, String name, double money, byte[] photo) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.photo = photo;
    }

    public HotelEntity(String name, double money, byte[] photo) {
        this.name = name;
        this.money = money;
        this.photo = photo;
    }
    public HotelEntity(){
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HotelEntity that = (HotelEntity) o;
        return id == that.id && Double.compare(money, that.money) == 0 && Objects.equals(name, that.name) && Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, money, photo);
    }

    @Override
    public String toString() {
        return "HotelEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", photo=" + photo +
                '}';
    }
}
