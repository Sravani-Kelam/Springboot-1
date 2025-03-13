package com.department.demo.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="dept")
@Data
public class DepartmentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
    private String name;
    private  int departments;
    private double marks;

    public DepartmentDto(int id, String name, int departments, double marks) {
        this.id = id;
        this.name = name;
        this.departments = departments;
        this.marks = marks;
    }
    public DepartmentDto(){
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
}
