package by.itacademy.fitness.core.recipe.converter;

import by.itacademy.fitness.core.product.dto.ProductDTO;
import by.itacademy.fitness.core.recipe.dto.RecipeDTO;
import by.itacademy.fitness.core.recipe.dto.RecipeIngredientDTO;
import by.itacademy.fitness.dao.product.entity.Product;
import by.itacademy.fitness.dao.recipe.entity.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeEntityToDTOConverter implements Converter<Recipe, RecipeDTO> {
    private Converter<Product, ProductDTO> productDTOConverter;

    public RecipeEntityToDTOConverter(Converter<Product, ProductDTO> productDTOConverter) {
        this.productDTOConverter = productDTOConverter;
    }

    @Override
    public RecipeDTO convert(Recipe source) {
        List<RecipeIngredientDTO> productList = source.getRecipeIngredients().stream()
                .map(recipeIngredient -> new RecipeIngredientDTO(
                        productDTOConverter.convert(recipeIngredient.getProduct()),
                        recipeIngredient.getWeight())).toList();

        return new RecipeDTO(source.getId(),
                source.getTitle(),
                source.getCreateDateTime(),
                source.getUpdateDateTime(),
                productList);
    }
}
