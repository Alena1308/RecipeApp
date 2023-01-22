package me.sky.recipeapp.services;

import me.sky.recipeapp.model.Recipe;

import java.util.Map;

public interface RecipeService {
    int putNewRecipe(Recipe recipe);
    Recipe getRecipe(int numberRecipe);

    Map<Integer, Recipe> getAllRecipes();

//    Recipe getRecipeByIdIngr(int id);

    Recipe editRecipe(int id, Recipe recipe);

    boolean deleteRecipe(int id);
}
