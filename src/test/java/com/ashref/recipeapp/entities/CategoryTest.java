package com.ashref.recipeapp.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CategoryTest {
    private Category category;
    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @Test
    public void getId() {
        Long id = 1L;
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    public void getName() {
        String name = "Test Category";
        category.setName(name);
        assertEquals(name, category.getName());
    }

    @Test
    public void getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        category.setRecipes(recipes);
        assertEquals(0, category.getRecipes().size());
    }
}