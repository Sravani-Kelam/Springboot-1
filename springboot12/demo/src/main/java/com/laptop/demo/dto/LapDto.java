package com.laptop.demo.dto;

import lombok.Data;

@Data
public class LapDto {
    private int id;
    private String name;
    private double storage;
    private double version;

    public LapDto(int id, String name, double storage, double version) {
        this.id = id;
        this.name = name;
        this.storage = storage;
        this.version = version;
    }
    public LapDto(){
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
}
