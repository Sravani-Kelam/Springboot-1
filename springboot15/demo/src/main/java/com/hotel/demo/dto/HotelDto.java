package com.hotel.demo.dto;

import java.sql.Blob;
import java.util.Objects;

public class HotelDto {
    private int id;
    private String name;
    private double money;
    private byte[] photo;

    public HotelDto(int id, String name, double money, byte[] photo) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.photo = photo;
    }

    public HotelDto(String name, double money, byte[] photo) {
        this.name = name;
        this.money = money;
        this.photo = photo;
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
        HotelDto hotelDto = (HotelDto) o;
        return id == hotelDto.id && Double.compare(money, hotelDto.money) == 0 && Objects.equals(name, hotelDto.name) && Objects.equals(photo, hotelDto.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, money, photo);
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", photo=" + photo +
                '}';
    }
}
