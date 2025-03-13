package com.astrology.demo.dto;

import lombok.Data;

@Data
public class AstroDto {
    private int id;
    private String name;
    private long phnnum;

    public AstroDto(int id, String name, long phnnum) {

        this.id = id;
        this.name = name;
        this.phnnum = phnnum;
    }
    public AstroDto(){
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
}
