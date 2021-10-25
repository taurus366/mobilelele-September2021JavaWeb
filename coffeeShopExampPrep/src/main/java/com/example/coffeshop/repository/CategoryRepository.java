package com.example.coffeshop.repository;

import com.example.coffeshop.model.entity.Category;
import com.example.coffeshop.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByName(CategoryNameEnum name);
}
