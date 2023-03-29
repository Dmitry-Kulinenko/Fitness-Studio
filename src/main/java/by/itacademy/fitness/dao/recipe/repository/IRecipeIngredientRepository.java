package by.itacademy.fitness.dao.recipe.repository;

import by.itacademy.fitness.dao.recipe.entity.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IRecipeIngredientRepository extends CrudRepository<RecipeIngredient, UUID> {
}
