package by.itacademy.fitness.core.recipe.converter;

import by.itacademy.fitness.core.recipe.dto.RecipeCreateUpdateDTO;
import by.itacademy.fitness.dao.product.repository.IProductRepository;
import by.itacademy.fitness.dao.recipe.entity.RecipeIngredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeCreateUpdateDTOToRecipeIngredientConverter implements Converter<RecipeCreateUpdateDTO, List<RecipeIngredient>> {
    private IProductRepository productRepository;

    public RecipeCreateUpdateDTOToRecipeIngredientConverter(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<RecipeIngredient> convert(RecipeCreateUpdateDTO source) {
        return source.getComposition().stream()
                .map(compositionItem -> new RecipeIngredient(
                        productRepository.findById(
                                compositionItem.getProduct()).orElseThrow(() ->
                                new IllegalArgumentException("Product not found")),
                        compositionItem.getWeight())).collect(Collectors.toCollection(ArrayList::new));
    }
}
