package by.itacademy.fitness.service.product.impl;

import by.itacademy.fitness.core.product.dto.ProductCreateUpdateDTO;
import by.itacademy.fitness.core.product.dto.ProductDTO;
import by.itacademy.fitness.dao.product.entity.Product;
import by.itacademy.fitness.dao.product.repository.IProductRepository;
import by.itacademy.fitness.service.product.api.IProductService;
import jakarta.transaction.Transactional;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class ProductService implements IProductService {
    private IProductRepository productRepository;
    private Converter<ProductCreateUpdateDTO, Product> dtoToEntityConverter;
    private Converter<Product, ProductDTO> entityToDtoConverter;

    public ProductService(IProductRepository productRepository,
                          Converter<ProductCreateUpdateDTO, Product> dtoToEntityConverter,
                          Converter<Product, ProductDTO> entityToDtoConverter) {
        this.productRepository = productRepository;
        this.dtoToEntityConverter = dtoToEntityConverter;
        this.entityToDtoConverter = entityToDtoConverter;
    }

    @Override
    public void add(ProductCreateUpdateDTO createUpdateDTO) {
        productRepository.save(dtoToEntityConverter.convert(createUpdateDTO));
    }

    @Override
    public Page<ProductDTO> getPage(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(entityToDtoConverter::convert);
    }

    @Override
    @Transactional
    public void update(UUID id, LocalDateTime updateDateTime, ProductCreateUpdateDTO createUpdateDTO) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Product not found"));

        if (!updateDateTime.equals(product.getUpdateDateTime())) {
            throw new IllegalArgumentException("dt_update isn't equal last dt_update value");
        }
        product.setTitle(createUpdateDTO.getTitle());
        product.setWeight(createUpdateDTO.getWeight());
        product.setCalories(createUpdateDTO.getCalories());
        product.setProteins(createUpdateDTO.getProteins());
        product.setFats(createUpdateDTO.getFats());
        product.setCarbohydrates(createUpdateDTO.getCarbohydrates());
        product.setUpdateDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        productRepository.save(product);
    }
}
