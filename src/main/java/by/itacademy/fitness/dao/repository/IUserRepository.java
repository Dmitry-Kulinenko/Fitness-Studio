package by.itacademy.fitness.dao.repository;

import by.itacademy.fitness.dao.entity.Role;
import by.itacademy.fitness.dao.entity.Status;
import by.itacademy.fitness.dao.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IUserRepository extends CrudRepository<User, UUID>, PagingAndSortingRepository<User, UUID> {
    @Transactional
    @Modifying
    @Query("""
            update User u set u.mail = ?1, u.password = ?2, u.fullName = ?3, u.role = ?4, u.status = ?5
            where u.uuid = ?6 and u.updateDateTime = ?7""")
    void updateUserData(String mail,
                        String password,
                        String fullName,
                        Role role,
                        Status status,
                        UUID uuid,
                        LocalDateTime updateDateTime);


}
