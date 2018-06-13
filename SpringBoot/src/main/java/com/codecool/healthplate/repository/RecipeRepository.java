package com.codecool.healthplate.repository;

import com.codecool.healthplate.models.Recipe;
import com.codecool.healthplate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    public List<Recipe> getRecipesByUser(User user);
}
