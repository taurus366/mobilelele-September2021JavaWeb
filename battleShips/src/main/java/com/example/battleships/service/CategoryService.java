package com.example.battleships.service;

import com.example.battleships.model.entity.Category;
import com.example.battleships.model.entity.CategoryEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryEnum category);
}
