package com.example.battleships.service.impl;

import com.example.battleships.model.entity.Category;
import com.example.battleships.model.entity.CategoryEnum;
import com.example.battleships.repository.CategoryRepository;
import com.example.battleships.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0){
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryNameEnum -> {

                        Category category = new Category();
                        category.setName(categoryNameEnum);
                        switch (categoryNameEnum){
                            case CARGO-> category.setName(CategoryEnum.CARGO);
                            case BATTLE -> category.setName(CategoryEnum.BATTLE);
                            case PATROL -> category.setName(CategoryEnum.PATROL);

                        }

                        categoryRepository.save(category);

                    });
        }
    }

    @Override
    public Category findByCategoryNameEnum(CategoryEnum category) {
        return categoryRepository.findByName(category).orElse(null);
    }
}
