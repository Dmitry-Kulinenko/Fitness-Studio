package by.itacademy.fitness.core.recipe.dto;

import by.itacademy.fitness.core.product.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@JsonPropertyOrder({
        "product",
        "weight",
        "calories",
        "proteins",
        "fats",
        "carbohydrates"
})
public class RecipeIngredientDTO {
    private ProductDTO product;
    private int weight;
    private double calories;
    private double proteins;
    private double fats;
    private double carbohydrates;

    public RecipeIngredientDTO(ProductDTO product, int weight) {
        this.product = product;
        this.weight = weight;
        this.calories = calculateRealAmount(product.getCalories());
        this.proteins = calculateRealAmount(product.getProteins());
        this.fats = calculateRealAmount(product.getFats());
        this.carbohydrates = calculateRealAmount(product.getCarbohydrates());
    }

    public ProductDTO getProduct() {
        return product;
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

    private double calculateRealAmount(double productValue) {
        int productWeight = product.getWeight();
        double realAmount = productValue / productWeight * weight;
        DecimalFormat df = new DecimalFormat(".##", DecimalFormatSymbols.getInstance(Locale.US));
        df.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(df.format(realAmount));
    }

}
