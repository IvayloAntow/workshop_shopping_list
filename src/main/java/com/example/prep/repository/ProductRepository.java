package com.example.prep.repository;

import com.example.prep.model.entity.ProductEntity;
import com.example.prep.model.entity.enums.CategoriesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity , String> {

    @Query("SELECT SUM(p.price) FROM ProductEntity p")
    BigDecimal findTotalProductsSum();

    @Query("SELECT p FROM ProductEntity p LEFT JOIN CategoriesEntity c ON p.category.id = c.id WHERE c.name = :category")
    List<ProductEntity> findAllByCategory_Name(@Param("category") CategoriesEnum categoriesEnum);
}
