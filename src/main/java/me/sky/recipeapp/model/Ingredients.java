package me.sky.recipeapp.model;

import java.util.Objects;

public class Ingredients {
    private String name;
    private int quantity;
    private String measurement;

    public Ingredients(String name, int quantity, String measurement) {
        this.name = validateString(name);
        this.quantity = validateInt(quantity);
        this.measurement = validateString(measurement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredients that = (Ingredients) o;
        return quantity == that.quantity && Objects.equals(name, that.name) && Objects.equals(measurement, that.measurement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, measurement);
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = validateInt(quantity);
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = validateString(measurement);
    }
}
