package me.sky.recipeapp.services;

import me.sky.recipeapp.model.Ingredients;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    public static Map<Integer, Ingredients> ingredientsMap = new LinkedHashMap<>();
    public static int idIngr = 0;

    @Override
    public int putNewIngr(Ingredients ingredient) {
        ingredientsMap.put(idIngr,ingredient);
        return idIngr++;
    }

    @Override
    public Ingredients getIngr(int id) {
        if(ingredientsMap.get(id) != null){
            return ingredientsMap.get(id);
        }
        return null;
    }

    @Override
    public Map<Integer, Ingredients> getAllIngr(){
        return ingredientsMap;
    }

    @Override
    public Ingredients editIngr(int id, Ingredients ingredient){
        if (ingredientsMap.containsKey(id)){
            ingredientsMap.put(id, ingredient);
        }
        return ingredient;
    }

    @Override
    public boolean deleteIngr(int id){
        if(ingredientsMap.containsKey(id)){
            ingredientsMap.remove(id);
            return true;
        }
        return false;
    }
}
