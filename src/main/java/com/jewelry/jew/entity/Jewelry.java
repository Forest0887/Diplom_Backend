package com.jewelry.jew.entity;

import jakarta.persistence.*;

@Entity
public class Jewelry {

    // поля сущности

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    // геттеры и сеттеры

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // конструкторы

    public Jewelry(String name) {
        this.name = name;
    }

    public Jewelry(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Jewelry() {
    }

}