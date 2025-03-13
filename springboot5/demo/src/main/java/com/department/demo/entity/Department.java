package com.department.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name="dept")
@Data

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String name;
     private int departments;
     private double marks;

    public Department(int id, String name, int departments, double marks) {
        this.id = id;
        this.name = name;
        this.departments = departments;
        this.marks = marks;
    }
    public Department(){
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

    public int getDepartments() {
        return departments;
    }

    public void setDepartments(int departments) {
        this.departments = departments;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && departments == that.departments && Double.compare(marks, that.marks) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, departments, marks);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departments=" + departments +
                ", marks=" + marks +
                '}';
    }
}
