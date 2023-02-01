package me.sky.recipeapp.services;

import me.sky.recipeapp.model.Recipe;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface RecipesService {
    int putNewRecipe(Recipe recipe);
    Recipe getRecipe(int numberRecipe);

    Map<Integer, Recipe> getAllRecipes();

//    Recipe getRecipeByIdIngr(int id);

    Recipe editRecipe(int id, Recipe recipe);

    Path getAllRecFile() throws IOException;

    boolean deleteRecipe(int id);
}
