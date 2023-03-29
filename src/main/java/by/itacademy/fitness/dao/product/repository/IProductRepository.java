package by.itacademy.fitness.dao.product.repository;

import by.itacademy.fitness.dao.product.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IProductRepository extends CrudRepository<Product, UUID>, PagingAndSortingRepository<Product, UUID> {
}
