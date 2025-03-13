package com.pro.jpa6.conductor.entity;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name="Apsrtc")

public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phn;
    private  String name;
    private String surname;


public Conductor(){}
    public Conductor(int phn, String name, String surname) {
        this.phn = phn;
        this.name = name;
        this.surname= surname;
    }



    public int getPhn() {
        return phn;
    }

    public void setPhn(int phn) {
        this.phn = phn;
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

    @Override
    public String toString() {
        return "Students{" +
                "phn=" + phn +
                ", name='" + name + '\'' +
                ", surname='" +surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Conductor conductor = (Conductor) o;
        return phn== conductor.phn && Objects.equals(name, conductor.name) && Objects.equals(surname, conductor.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phn, name, surname);
    }


}
