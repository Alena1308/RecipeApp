package me.sky.recipeapp.controllers;

import me.sky.recipeapp.model.Ingredients;
import me.sky.recipeapp.model.Recipe;
import me.sky.recipeapp.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping()
    public ResponseEntity<Integer> postNewRecipe(@RequestBody Recipe recipe) {
        int id = recipeService.putNewRecipe(recipe);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable int id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @GetMapping()
    public ResponseEntity<Map<Integer, Recipe>> getAllRecipes() {
        if (recipeService.getAllRecipes().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipeById(@PathVariable int id, @RequestBody Recipe newRecipe) {
        Recipe recipe = recipeService.editRecipe(id, newRecipe);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeById(@PathVariable int id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
