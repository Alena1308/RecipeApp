package me.sky.recipeapp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.sky.recipeapp.model.Ingredients;
import me.sky.recipeapp.model.Recipes;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecipesServiceImpl implements RecipesService {
    final private FilesService filesService;
    public static Map<Integer, Recipes> recipeMap = new LinkedHashMap<>();
    public static int idRecipe = 0;
    private IngredientsService ingredientsService;

    public RecipesServiceImpl(FilesService filesService, IngredientsService ingredientsService) {
        this.filesService = filesService;
        this.ingredientsService = ingredientsService;
    }

    @PostConstruct
    private void init(){
        readFromFileRec();
    }

    @Override
    public int putNewRecipe(Recipes recipe) {
        recipeMap.put(idRecipe, recipe);
        for(Ingredients ingredients : recipe.getIngredientsList()){
          if(!IngredientsServiceImpl.getIngredientsMap().containsValue(ingredients)){
              ingredientsService.putNewIngr(ingredients);
          }
        }
        saveToFileRec();
        return idRecipe++;
    }

    @Override
    public Recipes getRecipe(int id) {
        if (recipeMap.get(id) != null) {
            return recipeMap.get(id);
        }
        return null;
    }
    @Override
    public Map<Integer, Recipes> getAllRecipes(){
        return recipeMap;
    }

    @Override
    public Recipes editRecipe(int id, Recipes recipe){
        if (recipeMap.containsKey(id)){
            Recipes oldRecipe = recipeMap.get(id);
            for (Ingredients ingredient : oldRecipe.getIngredientsList()){
                if (IngredientsServiceImpl.getIngredientsMap().containsValue(ingredient)){
                    ingredientsService.deleteIngr(ingredient);
                }
            }
            recipeMap.put(id, recipe);
            for(Ingredients ingredients : recipe.getIngredientsList()) {
                if (!IngredientsServiceImpl.getIngredientsMap().containsValue(ingredients)) {
                    ingredientsService.putNewIngr(ingredients);
                }
            }
        }
        saveToFileRec();
        return recipe;
    }

    @Override
    public boolean deleteRecipe(int id){
        if(recipeMap.containsKey(id)) {
            Recipes recipe =recipeMap.get(id);
            for (Ingredients ingredient : recipe.getIngredientsList()) {
                if (IngredientsServiceImpl.getIngredientsMap().containsValue(ingredient)) {
                    ingredientsService.deleteIngr(ingredient);
                }
            }
            recipeMap.remove(id);
            return true;
        }
        return false;
    }
    private void saveToFileRec(){
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            filesService.saveToFileRec(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private void readFromFileRec(){
        String json = filesService.readFromFileRec();
        try {
            recipeMap = new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Recipes>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
