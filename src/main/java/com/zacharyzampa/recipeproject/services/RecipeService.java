package com.zacharyzampa.recipeproject.services;

import com.zacharyzampa.recipeproject.commands.RecipeCommand;
import com.zacharyzampa.recipeproject.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
