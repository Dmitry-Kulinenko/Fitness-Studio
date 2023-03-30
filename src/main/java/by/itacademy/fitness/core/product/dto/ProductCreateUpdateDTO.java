package by.itacademy.fitness.core.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductCreateUpdateDTO {
    @NotBlank(message = "The title is blank")
    private String title;
    @NotNull(message = "The weight is null")
    private int weight;
    @NotNull(message = "The calories value is null")
    private int calories;
    @NotNull(message = "The proteins value is null")
    private double proteins;
    @NotNull(message = "The fats value is null")
    private double fats;
    @NotNull(message = "The carbohydrates value is null")
    private double carbohydrates;

    public ProductCreateUpdateDTO(String title,
                                  int weight,
                                  int calories,
                                  double proteins,
                                  double fats,
                                  double carbohydrates) {
        this.title = title;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public String getTitle() {
        return title;
    }

    public int getWeight() {
        return weight;
    }

    public int getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }
}
