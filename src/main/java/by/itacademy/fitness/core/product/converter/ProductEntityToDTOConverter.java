package by.itacademy.fitness.core.product.converter;

import by.itacademy.fitness.core.product.dto.ProductDTO;
import by.itacademy.fitness.dao.product.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ProductEntityToDTOConverter implements Converter<Product, ProductDTO> {
    @Override
    public ProductDTO convert(Product source) {
        return new ProductDTO(source.getId(),
                source.getCreationDateTime(),
                source.getUpdateDateTime(),
                source.getTitle(),
                source.getWeight(),
                source.getCalories(),
                source.getProteins(),
                source.getFats(),
                source.getCarbohydrates());
    }
}
