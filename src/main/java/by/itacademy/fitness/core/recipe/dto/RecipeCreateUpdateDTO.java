package by.itacademy.fitness.core.recipe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class RecipeCreateUpdateDTO {
    @NotBlank(message = "The title is blank")
    private String title;
    @NotEmpty(message = "The composition is empty")
    private List<RecipeIngredientCreateUpdateDTO> composition;

    public RecipeCreateUpdateDTO(String title, List<RecipeIngredientCreateUpdateDTO> composition) {
        this.title = title;
        this.composition = composition;
    }

    public String getTitle() {
        return title;
    }

    public List<RecipeIngredientCreateUpdateDTO> getComposition() {
        return composition;
    }
}
