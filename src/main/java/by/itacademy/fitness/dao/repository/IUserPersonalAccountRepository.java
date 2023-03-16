package by.itacademy.fitness.dao.repository;

import by.itacademy.fitness.dao.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IUserPersonalAccountRepository extends CrudRepository<User, UUID> {
}
