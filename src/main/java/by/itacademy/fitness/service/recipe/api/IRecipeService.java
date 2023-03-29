package by.itacademy.fitness.service.recipe.api;

import by.itacademy.fitness.core.recipe.dto.RecipeCreateUpdateDTO;
import by.itacademy.fitness.core.recipe.dto.RecipeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IRecipeService {
    void add(RecipeCreateUpdateDTO createUpdateDTO);

    Page<RecipeDTO> getPage(Pageable pageable);

    void update(UUID uuid, LocalDateTime updateDateTime, RecipeCreateUpdateDTO createUpdateDTO);
}
