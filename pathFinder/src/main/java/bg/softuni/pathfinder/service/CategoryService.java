package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.entity.enums.CategoryNameEnum;

import java.util.Optional;

public interface CategoryService {

    Category findByName(CategoryNameEnum categoryEnum);
}
