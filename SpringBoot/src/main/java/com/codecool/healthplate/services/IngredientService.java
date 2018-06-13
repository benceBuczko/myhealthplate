package com.codecool.healthplate.services;

import com.codecool.healthplate.models.Ingredient;
import com.codecool.healthplate.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public void saveIngredient(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }
}
