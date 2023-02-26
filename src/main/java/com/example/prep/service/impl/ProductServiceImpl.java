package com.example.prep.service.impl;

import com.example.prep.model.entity.ProductEntity;
import com.example.prep.model.entity.enums.CategoriesEnum;
import com.example.prep.model.service.ProductServiceModel;
import com.example.prep.model.view.ProductViewModel;
import com.example.prep.repository.ProductRepository;
import com.example.prep.service.CategoryService;
import com.example.prep.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
        product.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        return productRepository.findTotalProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategory(CategoriesEnum categoriesEnum) {
        List<ProductViewModel>p= productRepository.
                findAllByCategory_Name(categoriesEnum)
                .stream().map(productEntity -> modelMapper.map(productEntity, ProductViewModel.class))
                .collect(Collectors.toList());
        return p;
    }

    @Override
    public void buyById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
