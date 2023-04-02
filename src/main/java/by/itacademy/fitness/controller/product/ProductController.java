package by.itacademy.fitness.controller.product;

import by.itacademy.fitness.core.product.dto.ProductCreateUpdateDTO;
import by.itacademy.fitness.core.product.dto.ProductDTO;
import by.itacademy.fitness.service.product.api.IProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody ProductCreateUpdateDTO productDTO) {
        productService.add(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public Page<ProductDTO> getPage(Pageable pageable) {
        return productService.getPage(pageable);
    }

    @PutMapping("/{uuid}/dt_update/{lastUpdated}")
    public ResponseEntity update(@PathVariable UUID uuid,
                                 @PathVariable LocalDateTime lastUpdated,
                                 @RequestBody @Valid ProductCreateUpdateDTO createUpdateDTO) {
        productService.update(uuid, lastUpdated, createUpdateDTO);
        return ResponseEntity.ok().build();
    }
}
