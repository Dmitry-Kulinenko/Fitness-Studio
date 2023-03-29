package by.itacademy.fitness.service.product.api;

import by.itacademy.fitness.core.product.dto.ProductCreateUpdateDTO;
import by.itacademy.fitness.core.product.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    void addProduct(ProductCreateUpdateDTO createUpdateDTO);

    Page<ProductDTO> getPage(Pageable pageable);
}
