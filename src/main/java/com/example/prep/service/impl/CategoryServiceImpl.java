package com.example.prep.service.impl;

import com.example.prep.model.entity.CategoriesEntity;
import com.example.prep.model.entity.enums.CategoriesEnum;
import com.example.prep.repository.CategoryRepository;
import com.example.prep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
//pulni kategoriite(imenata)
    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoriesEnum.values())
                    .forEach(CategoriesEnum -> {
                        CategoriesEntity categories = new CategoriesEntity(CategoriesEnum,
                                "Description for " + CategoriesEnum.name());

                        categoryRepository.save(categories);
                    });
        }
    }
}
