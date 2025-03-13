package com.stations.demo.dto;

import lombok.Data;

@Data
public class StationDto {
    private int id;
    private String name;
    private int platnum;

    public StationDto(int id, String name, int platnum) {
        this.id = id;
        this.name = name;
        this.platnum = platnum;
    }
    public StationDto(){
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
}
