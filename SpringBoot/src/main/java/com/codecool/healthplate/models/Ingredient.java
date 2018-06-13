package com.codecool.healthplate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double energy;

    @Column(nullable = false)
    @ManyToMany(mappedBy = "ingredients")
    private transient List<Recipe> recipes = new ArrayList<>();

    public Ingredient(String name, double energy) {
        this.name = name;
        this.energy = energy;
    }

    public Ingredient(){

    }
}
