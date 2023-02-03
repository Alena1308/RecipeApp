package me.sky.recipeapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.sky.recipeapp.model.Recipe;
import me.sky.recipeapp.services.RecipesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/recipes")
@Tag(name = "РЕЦЕПТЫ", description = "CRUD-опереации и другие эндпоинты для работы с рецептами")
public class RecipesController {
    private final RecipesService recipeService;

    public RecipesController(RecipesService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping()
    @Operation(summary = "Добавление рецепта")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Рецепт добавлен", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
            }
            )})
    public ResponseEntity<Integer> postNewRecipe(@Valid @RequestBody Recipe recipe) {
        int id = recipeService.putNewRecipe(recipe);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Поиск рецепта по id",
            description = "Нужно искать по одному параметру")
    @Parameters(value = {@Parameter(name = "id", example = "1")})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Рецепт был найден", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
            }
            )})
    public ResponseEntity<Recipe> getRecipeById(@PathVariable int id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @GetMapping()
    @Operation(summary = "Получение списка всех рецептов")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Рецепты найдены", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
            }
            )})
    public ResponseEntity<Map<Integer, Recipe>> getAllRecipes() {
        if (recipeService.getAllRecipes().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактирование рецепта по id")
    @Parameters(value = {@Parameter(name = "id", example = "1")})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Осуществлено редактирование рецепта", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
            }
            )})
    public ResponseEntity<Recipe> editRecipeById(@PathVariable int id, @Valid @RequestBody Recipe newRecipe) {
        Recipe recipe = recipeService.editRecipe(id, newRecipe);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление рецепта по id")
    @Parameters(value = {@Parameter(name = "id", example = "1")})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Рецепт удален", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
            }
            )})
    public ResponseEntity<Void> deleteRecipeById(@PathVariable int id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
