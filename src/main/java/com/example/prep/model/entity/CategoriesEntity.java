package com.example.prep.model.entity;

import com.example.prep.model.entity.enums.CategoriesEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoriesEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoriesEnum name;

    @Column(name = "description" , columnDefinition = "TEXT")
    private String description;

    public CategoriesEntity() {
    }

    public CategoriesEntity(CategoriesEnum name, String description) {
        this.name = name;
        this.description = description;


    }

    public CategoriesEnum getName() {
        return name;
    }

    public CategoriesEntity setName(CategoriesEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoriesEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
