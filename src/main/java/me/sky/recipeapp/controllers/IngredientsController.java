package me.sky.recipeapp.controllers;

import me.sky.recipeapp.model.Ingredients;
import me.sky.recipeapp.services.IngredientsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ingredient")
public class IngredientsController {
    private IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }
//    Ingredients eggs = new Ingredients("Яйца", 3, "шт");
//    Ingredients sugar = new Ingredients("Сахар", 3, "ст.л.");
//    Ingredients salt = new Ingredients("Соль", 5, "гр");
//    Ingredients milk = new Ingredients("Молоко", 500, "мл");
//    Ingredients flour = new Ingredients("Мука", 2, "стакан");
//    Ingredients oil = new Ingredients("Масло", 3, "ст.л.");

    @GetMapping("/new")
    public void putNewIngr(@RequestParam Ingredients ingredient){ingredientsService.putNewIngr(ingredient);}
    @GetMapping("/get")
    public Ingredients getIngr(@RequestParam int numIngr){return ingredientsService.getIngr(numIngr);}

}
