package com.book.demo.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class BookDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private  double page;

    public BookDto(int id, String name, double page) {
        this.id = id;
        this.name = name;
        this.page = page;
    }
    public BookDto(){
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

    public double getPage() {
        return page;
    }

    public void setPage(double page) {
        this.page = page;
    }
}
