package com.course.demo.dto;

import jakarta.persistence.Lob;

import java.sql.Blob;
import java.util.Objects;

public class CourseDto {
    private int id;
    private String name;
    private double fee;
    private byte[] photo;

    public CourseDto(String name, double fee, byte[] photo) {
        this.name = name;
        this.fee = fee;
        this.photo = photo;
    }

    public CourseDto(int id, String name, double fee, byte[] photo) {
        this.id = id;
        this.name = name;
        this.fee = fee;
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

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
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
        CourseDto courseDto = (CourseDto) o;
        return id == courseDto.id && Double.compare(fee, courseDto.fee) == 0 && Objects.equals(name, courseDto.name) && Objects.equals(photo, courseDto.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fee, photo);
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fee=" + fee +
                ", photo=" + photo +
                '}';
    }
}
