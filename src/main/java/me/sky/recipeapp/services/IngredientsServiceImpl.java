package me.sky.recipeapp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.sky.recipeapp.model.Ingredients;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    final private FilesService filesService;
    private static Map<Integer, Ingredients> ingredientsMap = new LinkedHashMap<>();
    public static Integer idIngr = 0;

    public IngredientsServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostConstruct
    private void init(){
        readFromFileIngr();
    }

    @Override
    public Ingredients putNewIngr(Ingredients ingredient) {
        ingredientsMap.put(idIngr++,ingredient);
        saveToFileIngr();
        return ingredient;
    }

    @Override
    public Ingredients getIngr(Integer id) {
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
    public Ingredients editIngr(Integer id, Ingredients ingredient){
        if (!ingredientsMap.containsKey(id)) {
            throw new NoSuchElementException("Ингредиент с данным id не найден");
        }
        ingredientsMap.put(id, ingredient);
        saveToFileIngr();
        return ingredient;
    }

    @Override
    public boolean deleteIngr(Integer id){
        if(ingredientsMap.containsKey(id)){
            ingredientsMap.remove(id);
            saveToFileIngr();
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteIngr(Ingredients ingredients){
        if(ingredientsMap.containsValue(ingredients)){
            for (Map.Entry<Integer, Ingredients>entry : ingredientsMap.entrySet()) {
                Integer id = entry.getKey();
                ingredientsMap.remove(id);
                saveToFileIngr();
            }
            return true;
        }
        return false;
    }

    private void saveToFileIngr(){
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientsMap);
            filesService.saveToFileIngr(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private void readFromFileIngr(){
        String json = filesService.readFromFileIngr();
        try {
            ingredientsMap = new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Ingredients>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<Integer, Ingredients> getIngredientsMap(){
        return ingredientsMap;
    }
}
