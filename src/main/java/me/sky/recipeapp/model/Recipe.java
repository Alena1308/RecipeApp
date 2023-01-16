package me.sky.recipeapp.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Recipe {
    private String name;
    private int time;
    private List<Ingredients> ingredientsList = new LinkedList<>();
    private List<String[]> steps = new LinkedList<>();

    public Recipe(String name, int time, List<Ingredients> ingredientsList, List<String[]> steps) {
        this.name = validateString(name);
        this.time = validateInt(time);
        this.ingredientsList = ingredientsList;
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return time == recipe.time && Objects.equals(name, recipe.name) && Objects.equals(ingredientsList, recipe.ingredientsList) && Objects.equals(steps, recipe.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, time, ingredientsList, steps);
    }

    public static String validateString (String value){
        if (value == null || value.isEmpty() || value.isBlank()) {
            throw new IllegalArgumentException ("Некорректное название");
        } else{
            return value;
        }
    }
    public static int validateInt (int value) {
        if (value == 0 || value < 0){
            throw new IllegalArgumentException ("Некорректное количество");
        } else{
            return value;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = validateString(name);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = validateInt(time);
    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public List<String[]> getSteps() {
        return steps;
    }
}
