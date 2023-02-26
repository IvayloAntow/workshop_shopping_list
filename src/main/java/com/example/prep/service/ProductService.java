package com.example.prep.service;

import com.example.prep.model.entity.enums.CategoriesEnum;
import com.example.prep.model.service.ProductServiceModel;
import com.example.prep.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {


    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategory(CategoriesEnum categoriesEnum);

    void buyById(String id);

    void buyAll();
}
