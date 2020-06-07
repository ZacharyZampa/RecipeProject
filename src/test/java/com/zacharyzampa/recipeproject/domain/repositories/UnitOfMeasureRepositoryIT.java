package com.zacharyzampa.recipeproject.domain.repositories;

import com.zacharyzampa.recipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest  // bring up an embedded database and configure Spring Data JPA
class UnitOfMeasureRepositoryIT {

    @Autowired  // dependency inject to here
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    // @DirtiesContext  // Good to use if doing something in the test that would change the data in but do NOT want contamination in other tests
    void findByDescription() {

        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", unitOfMeasureOptional.get().getDescription());

    }

    @Test
    void findByDescriptionCup() {

        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", unitOfMeasureOptional.get().getDescription());

    }
}