package com.example.prep.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity{

    @Column(unique = true , nullable = false)
    private String name;

    @Column(name = "description" , columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "needed_before" )
    private LocalDate neededBefore;

    // mnogo producti kum edna kategoriq
    @ManyToOne
    private CategoriesEntity categoy;

    public ProductEntity() {
    }

    public String getName() {
        return name;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getNeededBefore() {
        return neededBefore;
    }

    public ProductEntity setNeededBefore(LocalDate neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public CategoriesEntity getCategoy() {
        return categoy;
    }

    public ProductEntity setCategoy(CategoriesEntity categoy) {
        this.categoy = categoy;
        return this;
    }
}
