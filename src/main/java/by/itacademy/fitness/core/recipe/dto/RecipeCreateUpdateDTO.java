package by.itacademy.fitness.core.recipe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class RecipeCreateUpdateDTO {
    @NotBlank(message = "The title is blank")
    private String title;
    @NotNull(message = "The composition is null")
    @Size(min = 1, message = "Composition must include at least 1 element")
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
