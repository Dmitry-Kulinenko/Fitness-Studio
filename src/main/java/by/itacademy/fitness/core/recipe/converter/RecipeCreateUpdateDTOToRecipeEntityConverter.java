package by.itacademy.fitness.core.recipe.converter;

import by.itacademy.fitness.core.recipe.dto.RecipeCreateUpdateDTO;
import by.itacademy.fitness.dao.recipe.entity.Recipe;
import by.itacademy.fitness.dao.recipe.entity.RecipeIngredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeCreateUpdateDTOToRecipeEntityConverter
        implements Converter<RecipeCreateUpdateDTO, Recipe> {

    private Converter<RecipeCreateUpdateDTO, List<RecipeIngredient>> dtoToRecipeIngredientConverter;

    public RecipeCreateUpdateDTOToRecipeEntityConverter(Converter<RecipeCreateUpdateDTO, List<RecipeIngredient>> dtoToRecipeIngredientConverter) {
        this.dtoToRecipeIngredientConverter = dtoToRecipeIngredientConverter;
    }


    @Override
    public Recipe convert(RecipeCreateUpdateDTO source) {
        List<RecipeIngredient> recipeIngredients = dtoToRecipeIngredientConverter.convert(source);
        return new Recipe(source.getTitle(), recipeIngredients);
    }
}
