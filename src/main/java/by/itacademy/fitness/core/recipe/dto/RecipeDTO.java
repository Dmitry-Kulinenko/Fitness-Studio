package by.itacademy.fitness.core.recipe.dto;

import by.itacademy.fitness.core.timeconverter.json.LocalDateTimeToLong;
import by.itacademy.fitness.core.timeconverter.json.LongToLocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@JsonPropertyOrder({
        "uuid",
        "dt_create",
        "dt_update",
        "title",
        "composition",
        "weight",
        "calories",
        "proteins",
        "fats",
        "carbohydrates"
})
public class RecipeDTO {
    private UUID uuid;
    @JsonSerialize(converter = LocalDateTimeToLong.class)
    @JsonDeserialize(converter = LongToLocalDateTime.class)
    private LocalDateTime createDateTime;
    @JsonSerialize(converter = LocalDateTimeToLong.class)
    @JsonDeserialize(converter = LongToLocalDateTime.class)
    private LocalDateTime updateDateTime;
    private String title;
    private List<RecipeIngredientDTO> recipeIngredients;
    private int weight;
    private double calories;
    private double proteins;
    private double fats;
    private double carbohydrates;

    public RecipeDTO(UUID uuid,
                     String title,
                     LocalDateTime createDateTime,
                     LocalDateTime updateDateTime,
                     List<RecipeIngredientDTO> recipeIngredients) {
        this.uuid = uuid;
        this.title = title;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.recipeIngredients = recipeIngredients;
        this.weight = sumWeight(recipeIngredients);
        this.calories = sumValues(recipeIngredients.stream()
                .map(RecipeIngredientDTO::getCalories).toList());
        this.proteins = sumValues(recipeIngredients.stream()
                .map(RecipeIngredientDTO::getProteins).toList());
        this.fats = sumValues(recipeIngredients.stream()
                .map(RecipeIngredientDTO::getFats).toList());
        this.carbohydrates = sumValues(recipeIngredients.stream()
                .map(RecipeIngredientDTO::getCarbohydrates).toList());
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    @JsonProperty("dt_create")
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    @JsonProperty("dt_update")
    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    @JsonProperty("composition")
    public List<RecipeIngredientDTO> getRecipeIngredients() {
        return recipeIngredients;
    }

    public int getWeight() {
        return weight;
    }

    public double getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    private int sumWeight(List<RecipeIngredientDTO> recipeIngredients) {
        int sum = 0;
        for (RecipeIngredientDTO recipeIngredientDTO :
                recipeIngredients) {
            sum += recipeIngredientDTO.getWeight();
        }
        return sum;
    }

    private double sumValues(List<Double> recipeIngredients) {
        double sum = 0;
        for (Double recipeIngredientDTO :
                recipeIngredients) {
            sum += recipeIngredientDTO;
        }

        DecimalFormat df = new DecimalFormat(".##", DecimalFormatSymbols.getInstance(Locale.US));
        df.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(df.format(sum));
    }
}
