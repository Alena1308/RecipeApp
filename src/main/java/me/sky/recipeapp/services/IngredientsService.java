package me.sky.recipeapp.services;

import me.sky.recipeapp.model.Ingredients;


public interface IngredientsService {
    void putNewIngr(Ingredients ingredient);
    Ingredients getIngr(int numberIngredient);
}
