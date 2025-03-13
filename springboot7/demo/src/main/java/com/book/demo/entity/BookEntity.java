package com.book.demo.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private  double page;

    public BookEntity(int id, String name, double page) {
        this.id = id;
        this.name = name;
        this.page = page;
    }
    public BookEntity(){
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id && Double.compare(page, that.page) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, page);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", page=" + page +
                '}';
    }
}
