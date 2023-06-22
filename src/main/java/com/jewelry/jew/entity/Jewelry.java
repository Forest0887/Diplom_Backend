package com.jewelry.jew.entity;

import jakarta.persistence.*;

@Entity
public class Jewelry {
    // поля сущности
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String name_id;
    private String description;
    private Integer price;
    private String pathToPic;
    private String category;
    private Integer amount; //  количество

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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getName_id() { return name_id; }
    public void setName_id(String name_id) { this.name_id = name_id; }
    public String getPathToPic() { return pathToPic; }
    public void setPathToPic(String pathToPic) { this.pathToPic = pathToPic; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }

    // конструкторы
    public Jewelry(long id, String name, String name_id, String description, Integer price) {
        this.id = id;
        this.name = name;
        this.name_id = name_id;
        this.description = description;
        this.price = price;
    }

    public Jewelry(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Jewelry(String name) {
        this.name = name;
    }

    public Jewelry() {
    }

}