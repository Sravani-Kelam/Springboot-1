package com.rapido.demo.dto;

import com.rapido.demo.entity.RapidoEntity;
import lombok.Data;

@Data
public class RapidoDto {
    private int id;
    private String name;
    private long phnnum;
    private String place;

    public RapidoDto(int id, String name, long phnnum, String place) {
        this.id = id;
        this.name = name;
        this.phnnum = phnnum;
        this.place = place;
    }
    public RapidoDto(){
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
