package by.itacademy.fitness.core.product.dto;

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
import java.util.Locale;
import java.util.UUID;

@JsonPropertyOrder({
        "uuid",
        "dt_create",
        "dt_update",
        "title",
        "weight",
        "calories",
        "proteins",
        "fats",
        "carbohydrates"
})
public class ProductDTO {
    private UUID id;
    @JsonSerialize(converter = LocalDateTimeToLong.class)
    @JsonDeserialize(converter = LongToLocalDateTime.class)
    private LocalDateTime creationDateTime;
    @JsonSerialize(converter = LocalDateTimeToLong.class)
    @JsonDeserialize(converter = LongToLocalDateTime.class)
    private LocalDateTime updateDateTime;
    private String title;
    private int weight;
    private int calories;
    private double proteins;
    private double fats;
    private double carbohydrates;

    public ProductDTO(UUID id,
                      LocalDateTime creationDateTime,
                      LocalDateTime updateDateTime,
                      String title,
                      int weight,
                      int calories,
                      double proteins,
                      double fats,
                      double carbohydrates) {
        this.id = id;
        this.creationDateTime = creationDateTime;
        this.updateDateTime = updateDateTime;
        this.title = title;
        this.weight = weight;
        this.calories = calories;
        this.proteins = calculateRealAmount(proteins);
        this.fats = calculateRealAmount(fats);
        this.carbohydrates = calculateRealAmount(carbohydrates);
    }

    @JsonProperty("uuid")
    public UUID getId() {
        return id;
    }

    @JsonProperty("dt_create")
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    @JsonProperty("dt_update")
    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public String getTitle() {
        return title;
    }

    public int getWeight() {
        return weight;
    }

    public int getCalories() {
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

    private double calculateRealAmount(double productValue) {
        DecimalFormat df = new DecimalFormat(".##", DecimalFormatSymbols.getInstance(Locale.US));
        df.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(df.format(productValue));
    }
}
