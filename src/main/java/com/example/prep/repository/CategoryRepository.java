package com.example.prep.repository;

import com.example.prep.model.entity.CategoriesEntity;
import com.example.prep.model.entity.enums.CategoriesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoriesEntity , String> {

    Optional<CategoriesEntity> findByName(CategoriesEnum name);
}
