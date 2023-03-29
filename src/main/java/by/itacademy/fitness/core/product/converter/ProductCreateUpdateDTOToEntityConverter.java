package by.itacademy.fitness.core.product.converter;

import by.itacademy.fitness.core.product.dto.ProductCreateUpdateDTO;
import by.itacademy.fitness.dao.product.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateUpdateDTOToEntityConverter implements Converter<ProductCreateUpdateDTO, Product> {

    @Override
    public Product convert(ProductCreateUpdateDTO source) {
        return new Product(source.getTitle(),
                source.getWeight(),
                source.getCalories(),
                source.getProteins(),
                source.getFats(),
                source.getCarbohydrates()
        );
    }
}
