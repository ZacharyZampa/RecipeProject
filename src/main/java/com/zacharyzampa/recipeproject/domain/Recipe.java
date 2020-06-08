package com.zacharyzampa.recipeproject.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    // EnumType.String means that if another value was added in the enum there is a lower risk of it impacting
    //      the preexisting values in the table
    //      The default is EnumType.ORDINAL
    @Enumerated(value = EnumType.STRING)
    private DifficultyEnum difficulty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") // use Cascade since if recipe is delete Ingredients should be as well
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte[] image;  // The Hibernate team recommends use of the Wrapper of Byte as it can be null

    @OneToOne(cascade = CascadeType.ALL)  // use Cascade since if recipe is delete Note should be as well
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}