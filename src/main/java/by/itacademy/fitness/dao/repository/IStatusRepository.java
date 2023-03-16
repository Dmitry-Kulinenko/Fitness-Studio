package by.itacademy.fitness.dao.repository;

import by.itacademy.fitness.dao.entity.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IStatusRepository extends CrudRepository<Status, Integer> {
    Optional<Status> findByStatusIgnoreCase(String status);
}
