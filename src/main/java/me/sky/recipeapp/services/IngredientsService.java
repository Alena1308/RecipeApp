package me.sky.recipeapp.services;

import me.sky.recipeapp.model.Ingredients;

import java.util.Map;


public interface IngredientsService {
    Ingredients putNewIngr(Ingredients ingredient);
    Ingredients getIngr(int numberIngredient);

    Map<Integer, Ingredients> getAllIngr();

    Ingredients editIngr(int id, Ingredients ingredient);

    boolean deleteIngr(int id);
}
