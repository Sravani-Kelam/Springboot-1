package com.course.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.util.Objects;

@Entity
@Table(name="courses")
@Data
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double fee;
    @Lob
    private byte[] photo;

    public CourseEntity(int id, String name, double fee, byte[] photo) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.photo = photo;
    }

    public CourseEntity(String name, double fee, byte[] photo) {
        this.name = name;
        this.fee = fee;
        this.photo = photo;
    }
    public CourseEntity(){
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
        CourseEntity that = (CourseEntity) o;
        return id == that.id && Double.compare(fee, that.fee) == 0 && Objects.equals(name, that.name) && Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fee, photo);
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fee=" + fee +
                ", photo=" + photo +
                '}';
    }
}
