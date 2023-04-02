package by.itacademy.fitness.controller.recipe;

import by.itacademy.fitness.core.recipe.dto.RecipeCreateUpdateDTO;
import by.itacademy.fitness.core.recipe.dto.RecipeDTO;
import by.itacademy.fitness.service.recipe.api.IRecipeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {
    private final IRecipeService recipeService;

    public RecipeController(IRecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody RecipeCreateUpdateDTO createUpdateDTO) {
        recipeService.add(createUpdateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public Page<RecipeDTO> getPage(Pageable pageable) {
        return recipeService.getPage(pageable);
    }

    @PutMapping("/{uuid}/dt_update/{lastUpdated}")
    public ResponseEntity update(@PathVariable UUID uuid,
                                 @PathVariable LocalDateTime lastUpdated,
                                 @RequestBody @Valid RecipeCreateUpdateDTO createUpdateDTO) {
        recipeService.update(uuid, lastUpdated, createUpdateDTO);
        return ResponseEntity.ok().build();
    }
}
