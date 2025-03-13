package com.laptop.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name="laps")
@Data
public class LapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double storage;
    private double version;

    public LapEntity(int id, String name, double storage, double version) {
        this.id = id;
        this.name = name;
        this.storage = storage;
        this.version = version;
    }
    public LapEntity(){
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

    public double getStorage() {
        return storage;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LapEntity lapEntity = (LapEntity) o;
        return id == lapEntity.id && Double.compare(storage, lapEntity.storage) == 0 && Double.compare(version, lapEntity.version) == 0 && Objects.equals(name, lapEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, storage, version);
    }

    @Override
    public String toString() {
        return "LapEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", storage=" + storage +
                ", version=" + version +
                '}';
    }
}
