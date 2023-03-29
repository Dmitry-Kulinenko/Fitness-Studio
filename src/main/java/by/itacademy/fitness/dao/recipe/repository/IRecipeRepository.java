package by.itacademy.fitness.dao.recipe.repository;

import by.itacademy.fitness.dao.recipe.entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IRecipeRepository extends CrudRepository<Recipe, UUID>, PagingAndSortingRepository<Recipe, UUID> {
}
