package com.codecool.healthplate.services;

import com.codecool.healthplate.models.Recipe;
import com.codecool.healthplate.models.User;
import com.codecool.healthplate.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public void saveRecipe(Recipe recipe){
        recipeRepository.save(recipe);
    }

    public List<Recipe> getRecipesByUser(User user){
        return recipeRepository.getRecipesByUser(user);
    }
}
