package com.zacharyzampa.recipeproject.domain.repositories;

import com.zacharyzampa.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
