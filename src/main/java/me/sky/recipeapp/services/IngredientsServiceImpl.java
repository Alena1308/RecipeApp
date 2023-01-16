package me.sky.recipeapp.services;

import me.sky.recipeapp.model.Ingredients;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    public static Map<Integer, Ingredients> ingredientsMap = new LinkedHashMap<>();
    public static Integer idIngr = 0;

    @Override
    public void putNewIngr(Ingredients ingredient) {
        ingredientsMap.put(idIngr++,ingredient);
        System.out.println(ingredientsMap.toString());
    }

    @Override
    public Ingredients getIngr(int numberIngredient) {
        return ingredientsMap.get(numberIngredient);
    }
}
