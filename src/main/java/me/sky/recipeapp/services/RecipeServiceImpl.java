package me.sky.recipeapp.services;

import me.sky.recipeapp.model.Ingredients;
import me.sky.recipeapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    public static Map<Integer, Recipe> recipeMap = new LinkedHashMap<>();
    public static Integer idRecipe = 0;
    @Override
    public void putNewRecipe(Recipe recipe) {
        recipeMap.put(idRecipe++,recipe);
        System.out.println(recipeMap.toString());
    }

    @Override
    public Recipe getRecipe(int numberRecipe) {
        return recipeMap.get(numberRecipe);
    }
}
