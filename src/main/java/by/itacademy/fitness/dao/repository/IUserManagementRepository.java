package by.itacademy.fitness.dao.repository;

import by.itacademy.fitness.dao.entity.Role;
import by.itacademy.fitness.dao.entity.Status;
import by.itacademy.fitness.dao.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IUserManagementRepository extends CrudRepository<User, UUID>, PagingAndSortingRepository<User, UUID> {

    @Modifying
    @Query("""
            update User u set u.updateDateTime = ?1, u.mail = ?2, u.password = ?3, u.fullName = ?4, u.role = ?5, u.status = ?6
            where u.uuid = ?7""")
    void updateUpdateDateTimeAndMailAndPasswordAndFullNameAndRoleAndStatusByUuid(LocalDateTime updateDateTime,
                                                                                 String mail,
                                                                                 String password,
                                                                                 String fullName,
                                                                                 Role role,
                                                                                 Status status,
                                                                                 UUID uuid);


}
