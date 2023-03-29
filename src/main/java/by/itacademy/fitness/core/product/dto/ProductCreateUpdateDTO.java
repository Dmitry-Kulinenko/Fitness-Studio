package by.itacademy.fitness.core.product.dto;

import jakarta.validation.constraints.NotBlank;

public class ProductCreateUpdateDTO {
    @NotBlank(message = "The title is blank")
    private String title;
    @NotBlank(message = "The weight is blank")
    private int weight;
    @NotBlank(message = "The calories are blank")
    private int calories;
    @NotBlank(message = "The proteins are blank")
    private double proteins;
    @NotBlank(message = "The fats are blank")
    private double fats;
    @NotBlank(message = "The carbohydrates are blank")
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
