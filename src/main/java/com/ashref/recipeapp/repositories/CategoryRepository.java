package com.ashref.recipeapp.repositories;

import com.ashref.recipeapp.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
