package by.itacademy.fitness.dao.user.repository;

import by.itacademy.fitness.dao.user.entity.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IStatusRepository extends CrudRepository<Status, Integer> {
    Optional<Status> findByStatusIgnoreCase(String status);
}
