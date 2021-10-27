package com.example.coffeshop.service;

import com.example.coffeshop.model.entity.Category;
import com.example.coffeshop.model.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
