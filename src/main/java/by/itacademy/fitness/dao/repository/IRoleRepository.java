package by.itacademy.fitness.dao.repository;

import by.itacademy.fitness.dao.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IRoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByRoleIgnoreCase(String role);
}
