package com.zacharyzampa.recipeproject.services;

import com.zacharyzampa.recipeproject.domain.Recipe;
import com.zacharyzampa.recipeproject.domain.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;  // test the service

    @Mock
    RecipeRepository recipeRepository;  // need to inject the repository

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);  // tell Mockito to give a Mock RecipeRepository

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);
        // tell mockito to return the added recipe when recipeRepository.findAll() is called
        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);  // should be size 1 since one recipe was added through the mock

        // verify the interaction with the mock
        // In this test - want to ensure findAll() is called exactly once
        verify(recipeRepository, times(1)).findAll();

    }
}