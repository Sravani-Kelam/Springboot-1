package com.stations.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name="station")
@Data
public class StationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private int platnum;

    public StationEntity(int id, String name, int platnum) {
        this.id = id;
        this.name = name;
        this.platnum = platnum;
    }
    public StationEntity(){
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

    public int getPlatnum() {
        return platnum;
    }

    public void setPlatnum(int platnum) {
        this.platnum = platnum;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StationEntity that = (StationEntity) o;
        return id == that.id && platnum == that.platnum && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, platnum);
    }

    @Override
    public String toString() {
        return "StationEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", platnum=" + platnum +
                '}';
    }
}