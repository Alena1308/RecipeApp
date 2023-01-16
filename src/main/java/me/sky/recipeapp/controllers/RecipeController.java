package me.sky.recipeapp.controllers;

import me.sky.recipeapp.model.Recipe;
import me.sky.recipeapp.services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping("/new")
    public void putNewRecipe(@RequestParam Recipe recipe){recipeService.putNewRecipe(recipe);}
    @GetMapping("/get")
    public Recipe getRecipe(@RequestParam int numRecipe){return recipeService.getRecipe(numRecipe);}
}
