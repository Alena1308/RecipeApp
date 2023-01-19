package me.sky.recipeapp.services;

import me.sky.recipeapp.model.Ingredients;
import me.sky.recipeapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    public static Map<Integer, Recipe> recipeMap = new LinkedHashMap<>();
    public static int idRecipe = 0;

    @Override
    public int putNewRecipe(Recipe recipe) {
        recipeMap.put(idRecipe, recipe);
        return idRecipe++;
    }

    @Override
    public Recipe getRecipe(int id) {
        if (recipeMap.get(id) != null) {
            return recipeMap.get(id);
        }
        return null;
    }
    @Override
    public Map<Integer, Recipe> getAllRecipes(){
        return recipeMap;
    }

//    @Override
//    public Recipe getRecipeByIdIngr(int id) {
//        return null;
//    }

    @Override
    public Recipe editRecipe(int id, Recipe recipe){
        if (recipeMap.containsKey(id)){
            recipeMap.put(id, recipe);
        }
        return recipe;
    }

    @Override
    public boolean deleteRecipe(int id){
        if(recipeMap.containsKey(id)){
            recipeMap.remove(id);
            return true;
        }
        return false;
    }

}
