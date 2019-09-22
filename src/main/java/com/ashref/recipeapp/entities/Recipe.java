package com.ashref.recipeapp.entities;

import com.ashref.recipeapp.enums.Difficulty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;
    private Byte[] image;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Note note;
    @ManyToMany
    @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    public void addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.getIngredients().add(ingredient);
    }

    public void setNote(Note note) {
        note.setRecipe(this);
        this.note = note;
    }
}
