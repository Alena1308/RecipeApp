package me.sky.recipeapp.services;

import me.sky.recipeapp.model.Ingredients;

import java.util.Map;


public interface IngredientsService {
    Ingredients putNewIngr(Ingredients ingredient);
    Ingredients getIngr(Integer id);

    Map<Integer, Ingredients> getAllIngr();

    Ingredients editIngr(Integer id, Ingredients ingredient);

    boolean deleteIngr(Integer id);
}
