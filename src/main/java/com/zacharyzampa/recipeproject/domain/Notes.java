package com.zacharyzampa.recipeproject.domain;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne  // no cascade used as we do not want to delete a recipe if a note is deleted
    private Recipe recipe;

    @Lob  // allow more than the String database limit number of characters to go into the database
    private String recipeNotes;

}