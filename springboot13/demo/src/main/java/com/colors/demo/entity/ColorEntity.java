package com.colors.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name="color")
@Data
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double frequency;
    @Lob
    private byte[] photo;



    public ColorEntity(int id, String name, double frequency, byte[] photo) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
        this.photo = photo;
    }

    public ColorEntity(int id,String name, double frequency) {

    }

    public ColorEntity(){
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

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
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
        ColorEntity that = (ColorEntity) o;
        return id == that.id && Double.compare(frequency, that.frequency) == 0 && Objects.equals(name, that.name) && Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, frequency, photo);
    }

    @Override
    public String toString() {
        return "ColorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", frequency=" + frequency +
                ", photo=" + photo +
                '}';
    }
}
