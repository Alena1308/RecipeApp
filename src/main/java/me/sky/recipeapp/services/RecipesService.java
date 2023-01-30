package me.sky.recipeapp.services;

import me.sky.recipeapp.model.Recipes;

import java.util.Map;

public interface RecipesService {
    int putNewRecipe(Recipes recipe);
    Recipes getRecipe(int numberRecipe);

    Map<Integer, Recipes> getAllRecipes();

//    Recipe getRecipeByIdIngr(int id);

    Recipes editRecipe(int id, Recipes recipe);

    boolean deleteRecipe(int id);
}
