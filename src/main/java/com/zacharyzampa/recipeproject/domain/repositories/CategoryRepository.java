package com.zacharyzampa.recipeproject.domain.repositories;

import com.zacharyzampa.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
