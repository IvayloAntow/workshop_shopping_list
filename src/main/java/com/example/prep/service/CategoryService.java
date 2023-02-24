package com.example.prep.service;

import com.example.prep.model.entity.CategoriesEntity;
import com.example.prep.model.entity.enums.CategoriesEnum;

public interface CategoryService {
    void initCategories();

    CategoriesEntity findByName(CategoriesEnum categoryName);
}
