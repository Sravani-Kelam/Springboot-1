package com.movie.demo.dto;

import lombok.Data;

@Data
public class MovieDto {
    private int id;
    private String name;
    private long budget;
    private double tym;

    public MovieDto(int id, String name, long budget, double tym) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.tym = tym;
    }
    public MovieDto(){
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

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public double getTym() {
        return tym;
    }

    public void setTym(double tym) {
        this.tym = tym;
    }
}
