package com.example.prep.model.binding;

import com.example.prep.model.entity.enums.CategoriesEnum;
import com.example.prep.model.service.ProductServiceModel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    @NotBlank(message = "Cannot be empty")
    @Size(min = 3, max= 20,
    message = "Name must be between 3 and 20 characters")
    private String name;

    @Size(min = 5 , message = "Description must be min 5 characters")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past")
    private LocalDateTime neededBefore;

    @DecimalMin(value = "0", message = "Price cannot be positive")
    private BigDecimal price;

    @NotNull(message = "You must select the category")
    private CategoriesEnum category;

    public ProductAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoriesEnum getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoriesEnum category) {
        this.category = category;
        return this;
    }


}
