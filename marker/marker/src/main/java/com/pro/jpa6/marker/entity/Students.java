package com.pro.jpa6.marker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Entity
@Table(name="Folks")

public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private String department;


public Students(){}
    public Students(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id && Objects.equals(name, students.name) && Objects.equals(department, students.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }


}
