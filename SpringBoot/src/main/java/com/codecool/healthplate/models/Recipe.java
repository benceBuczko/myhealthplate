package com.codecool.healthplate.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @ManyToMany
    private List<Ingredient> ingredients;

    @ManyToOne
    private User user;

    @Column
    private String picture;


    public Recipe(String name, String description, List<Ingredient> ingredients, String picture, User user) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.picture = picture;
        this.user = user;
    }

    public Recipe(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }
}
