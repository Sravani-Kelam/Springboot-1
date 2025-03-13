package com.movie.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name="movies")
@Data
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long budget;
    private double tym;

    public MovieEntity(int id, String name, long budget, double tym) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.tym = tym;
    }
    public MovieEntity(){
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return id == that.id && budget == that.budget && Double.compare(tym, that.tym) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, budget, tym);
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", tym=" + tym +
                '}';
    }
}
