package com.rapido.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name="rap")
@Data
public class RapidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            private int id;
    private String name;
    private long phnnum;
    private String place;

    public RapidoEntity(int id, String name, long phnnum, String place) {
        this.id = id;
        this.name = name;
        this.phnnum = phnnum;
        this.place = place;
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

    public long getPhnnum() {
        return phnnum;
    }

    public void setPhnnum(long phnnum) {
        this.phnnum = phnnum;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public RapidoEntity(){
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RapidoEntity that = (RapidoEntity) o;
        return id == that.id && phnnum == that.phnnum && Objects.equals(name, that.name) && Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phnnum, place);
    }

    @Override
    public String toString() {
        return "RapidoEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phnnum=" + phnnum +
                ", place='" + place + '\'' +
                '}';
    }
}
