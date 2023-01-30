package me.sky.recipeapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Recipes {
    @NotBlank
    private String name;
    @Positive
    private int time;
    @NotEmpty
    private List<Ingredients> ingredientsList = new LinkedList<>();
    @NotEmpty
    private List<String[]> steps = new LinkedList<>();

}
