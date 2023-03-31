package by.itacademy.fitness.service.recipe.impl;

import by.itacademy.fitness.core.recipe.dto.RecipeCreateUpdateDTO;
import by.itacademy.fitness.core.recipe.dto.RecipeDTO;
import by.itacademy.fitness.dao.recipe.entity.Recipe;
import by.itacademy.fitness.dao.recipe.entity.RecipeIngredient;
import by.itacademy.fitness.dao.recipe.repository.IRecipeIngredientRepository;
import by.itacademy.fitness.dao.recipe.repository.IRecipeRepository;
import by.itacademy.fitness.service.recipe.api.IRecipeService;
import jakarta.transaction.Transactional;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class RecipeService implements IRecipeService {

    private IRecipeRepository recipeRepository;
    private IRecipeIngredientRepository recipeIngredientRepository;
    private Converter<Recipe, RecipeDTO> recipeToDTOConverter;
    private Converter<RecipeCreateUpdateDTO, Recipe> dtoToRecipeConverter;
    private Converter<RecipeCreateUpdateDTO, List<RecipeIngredient>> dtoToRecipeIngredientsConverter;

    public RecipeService(IRecipeRepository recipeRepository,
                         IRecipeIngredientRepository recipeIngredientRepository,
                         Converter<Recipe, RecipeDTO> recipeToDTOConverter,
                         Converter<RecipeCreateUpdateDTO, Recipe> dtoToRecipeConverter,
                         Converter<RecipeCreateUpdateDTO, List<RecipeIngredient>> dtoToRecipeIngredientsConverter) {
        this.recipeRepository = recipeRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeToDTOConverter = recipeToDTOConverter;
        this.dtoToRecipeConverter = dtoToRecipeConverter;
        this.dtoToRecipeIngredientsConverter = dtoToRecipeIngredientsConverter;
    }

    @Override
    public void add(RecipeCreateUpdateDTO createUpdateDTO) {
        recipeRepository.save(dtoToRecipeConverter.convert(createUpdateDTO));
    }

    @Override
    public Page<RecipeDTO> getPage(Pageable pageable) {
        Page<Recipe> recipePage = recipeRepository.findAll(pageable);
        return recipePage.map(recipeToDTOConverter::convert);
    }

    @Override
    @Transactional
    public void update(UUID uuid, LocalDateTime updateDateTime, RecipeCreateUpdateDTO createUpdateDTO) {
        Recipe recipe = recipeRepository.findById(uuid).orElseThrow(
                () -> new IllegalArgumentException("Recipe not found"));

        if (!updateDateTime.equals(recipe.getUpdateDateTime())) {
            throw new IllegalArgumentException("dt_update isn't equal last dt_update value");
        }

        List<RecipeIngredient> oldRecipeIngredients = recipe.getRecipeIngredients();
        List<RecipeIngredient> newRecipeIngredients = dtoToRecipeIngredientsConverter.convert(createUpdateDTO);
        recipe.setRecipeIngredients(newRecipeIngredients);
        recipe.setTitle(createUpdateDTO.getTitle());
        recipe.setUpdateDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        recipeRepository.save(recipe);
        recipeIngredientRepository.deleteAll(oldRecipeIngredients);
    }
}
