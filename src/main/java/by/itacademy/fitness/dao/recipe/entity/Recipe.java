package by.itacademy.fitness.dao.recipe.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "recipe", schema = "fitness")
public class Recipe {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    @Column(name = "dt_create")
    private LocalDateTime createDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    @Version
    @Column(name = "dt_update")
    private LocalDateTime updateDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "ingredient_recipe", schema = "fitness",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<RecipeIngredient> recipeIngredients;

    public Recipe() {
    }

    public Recipe(String title, List<RecipeIngredient> recipeIngredients) {
        this.title = title;
        this.recipeIngredients = recipeIngredients;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
}