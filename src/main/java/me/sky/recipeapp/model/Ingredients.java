package me.sky.recipeapp.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Ingredients {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Positive
    private int quantity;
    private String measurement;

}
