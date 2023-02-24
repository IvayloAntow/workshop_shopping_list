package com.example.prep.model.service;

import com.example.prep.model.entity.CategoriesEntity;
import com.example.prep.model.entity.enums.CategoriesEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductServiceModel {

    private String id;
    private String name;

    private String description;

    private BigDecimal price;

    private LocalDateTime neededBefore;

    private CategoriesEnum category;

    public ProductServiceModel() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }

    public CategoriesEnum getCategory() {
        return category;
    }

    public void setCategory(CategoriesEnum category) {
        this.category = category;
    }
}
