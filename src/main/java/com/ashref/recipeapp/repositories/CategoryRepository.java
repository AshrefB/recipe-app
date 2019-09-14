package com.ashref.recipeapp.repositories;

import com.ashref.recipeapp.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
