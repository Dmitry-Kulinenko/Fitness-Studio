package by.itacademy.fitness.service.product.impl;

import by.itacademy.fitness.core.product.dto.ProductCreateUpdateDTO;
import by.itacademy.fitness.core.product.dto.ProductDTO;
import by.itacademy.fitness.dao.product.entity.Product;
import by.itacademy.fitness.dao.product.repository.IProductRepository;
import by.itacademy.fitness.service.product.api.IProductService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public void addProduct(ProductCreateUpdateDTO createUpdateDTO) {
        productRepository.save(dtoToEntityConverter.convert(createUpdateDTO));
    }

    @Override
    public Page<ProductDTO> getPage(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(entityToDtoConverter::convert);
    }
}
