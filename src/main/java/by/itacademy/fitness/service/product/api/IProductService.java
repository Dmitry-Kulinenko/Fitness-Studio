package by.itacademy.fitness.service.product.api;

import by.itacademy.fitness.core.product.dto.ProductCreateUpdateDTO;
import by.itacademy.fitness.core.product.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IProductService {
    void add(ProductCreateUpdateDTO createUpdateDTO);

    Page<ProductDTO> getPage(Pageable pageable);

    void update(UUID uuid, LocalDateTime updateDateTime, ProductCreateUpdateDTO createUpdateDTO);
}
