package com.ashref.recipeapp.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String content;
    @OneToOne
    private Recipe recipe;

    public Note() {
    }

    public Note(String content) {
        this.content = content;
    }

    public Note(String content, Recipe recipe) {
        this.content = content;
        this.recipe = recipe;
    }

}
