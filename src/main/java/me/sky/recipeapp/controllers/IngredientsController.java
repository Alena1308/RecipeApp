package me.sky.recipeapp.controllers;

import me.sky.recipeapp.model.Ingredients;
import me.sky.recipeapp.services.IngredientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/ingredient")
public class IngredientsController {
    private IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping()
    public ResponseEntity<Integer> postNewIngr(@RequestBody Ingredients ingredient) {
        int id = ingredientsService.putNewIngr(ingredient);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredients> getIngrById(@PathVariable int id) {
        Ingredients ingredient = ingredientsService.getIngr(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping()
    public ResponseEntity<Map<Integer, Ingredients>> getAllIngr() {
        if (ingredientsService.getAllIngr().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredientsService.getAllIngr());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredients> editIngrById(@PathVariable int id, @RequestBody Ingredients newIngredient) {
        Ingredients ingredient = ingredientsService.editIngr(id, newIngredient);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngrById(@PathVariable int id) {
        if (ingredientsService.deleteIngr(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
