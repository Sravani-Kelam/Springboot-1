package com.pro.jpa6.conductor.dto;

public class ConductorDto {

    private int phn;
    private  String name;
    private String surname;


    public ConductorDto(int phn, String name, String surname) {
        this.phn = phn;
        this.name = name;
        this.surname = surname;
    }

    public ConductorDto() {
        super();
    }

    public ConductorDto(int phn) {
        this.phn= phn;
    }

    public ConductorDto(String surname) {
        this.surname= surname;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "phn=" + phn +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public int getPhn() {
        return phn;
    }

    public void setPhn(int id) {
        this.phn= phn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}

