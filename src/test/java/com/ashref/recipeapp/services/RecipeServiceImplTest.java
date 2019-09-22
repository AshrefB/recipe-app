package com.ashref.recipeapp.services;

import com.ashref.recipeapp.entities.Recipe;
import com.ashref.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    private RecipeService recipeService;
    @Mock
    private RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        when(recipeService.getRecipes()).thenReturn(recipes);

        assertEquals(1, recipeService.getRecipes().size());
        verify(recipeRepository, times(1)).findAll();
    }
}