package com.example.prep.service.impl;

import com.example.prep.model.entity.ProductEntity;
import com.example.prep.model.service.ProductServiceModel;
import com.example.prep.repository.ProductRepository;
import com.example.prep.service.CategoryService;
import com.example.prep.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        ProductEntity product = modelMapper.map(productServiceModel, ProductEntity.class);
        product.setCategoy(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(product);
    }
}
