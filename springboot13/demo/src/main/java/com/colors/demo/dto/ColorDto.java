package com.colors.demo.dto;

import lombok.Data;

import java.sql.Blob;
import java.util.Base64;
import java.util.Objects;

//@Data
public class ColorDto {
    private int id;
    private String name;
    private double frequency;
    private Byte[] photo;

    public ColorDto(int id, String name, double frequency, Byte[] photo) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
        this.photo = photo;
    }

    public ColorDto(String name, double frequency, Byte[] photo) {
        this.name = name;
        this.frequency = frequency;
        this.photo = photo;
    }

    public ColorDto(int id, String name, double frequency) {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ColorDto colorDto = (ColorDto) o;
        return id == colorDto.id && Double.compare(frequency, colorDto.frequency) == 0 && Objects.equals(name, colorDto.name) && Objects.equals(photo, colorDto.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, frequency, photo);
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

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }
}
