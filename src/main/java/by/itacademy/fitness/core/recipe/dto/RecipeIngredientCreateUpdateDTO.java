package by.itacademy.fitness.core.recipe.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class RecipeIngredientCreateUpdateDTO {
    @NotBlank(message = "The uuid is blank")
    private UUID product;
    @NotBlank(message = "The weight is blank")
    private int weight;

    public RecipeIngredientCreateUpdateDTO() {
    }

    public RecipeIngredientCreateUpdateDTO(UUID product, int weight) {
        this.product = product;
        this.weight = weight;
    }

    public UUID getProduct() {
        return product;
    }

    public void setProduct(UUID product) {
        this.product = product;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}