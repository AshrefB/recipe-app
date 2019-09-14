package com.ashref.recipeapp.services;

import com.ashref.recipeapp.entities.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
