package com.ashref.recipeapp.repositories;

import com.ashref.recipeapp.entities.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
