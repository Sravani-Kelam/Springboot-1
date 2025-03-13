package com.astrology.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name="Astro")
@Data
public class AstroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long phnnum;

    public AstroEntity(int id, String name, long phnnum) {
        this.id = id;
        this.name = name;
        this.phnnum = phnnum;
    }
    public AstroEntity(){
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

    public long getPhnnum() {
        return phnnum;
    }

    public void setPhnnum(long phnnum) {
        this.phnnum = phnnum;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AstroEntity that = (AstroEntity) o;
        return id == that.id && phnnum == that.phnnum && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phnnum);
    }

    @Override
    public String toString() {
        return "AstroEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phnnum=" + phnnum +
                '}';
    }
}
