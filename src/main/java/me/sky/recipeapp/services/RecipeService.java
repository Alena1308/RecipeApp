package me.sky.recipeapp.services;

import me.sky.recipeapp.model.Recipe;

public interface RecipeService {
    void putNewRecipe(Recipe recipe);
    Recipe getRecipe(int numberRecipe);
}
