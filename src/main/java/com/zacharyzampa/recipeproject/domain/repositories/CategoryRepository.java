package com.zacharyzampa.recipeproject.domain.repositories;

import com.zacharyzampa.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
