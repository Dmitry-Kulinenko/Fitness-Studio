package by.itacademy.fitness.dao.user.repository;

import by.itacademy.fitness.dao.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends CrudRepository<User, UUID>, PagingAndSortingRepository<User, UUID> {
    Optional<User> findByMail(String mail);

}
