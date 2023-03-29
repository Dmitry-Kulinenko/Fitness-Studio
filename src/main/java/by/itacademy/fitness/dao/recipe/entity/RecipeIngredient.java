package by.itacademy.fitness.dao.recipe.entity;

import by.itacademy.fitness.dao.product.entity.Product;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ingredient", schema = "fitness")
public class RecipeIngredient {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Product product;
    private int weight;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Product product, int weight) {
        this.product = product;
        this.weight = weight;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
