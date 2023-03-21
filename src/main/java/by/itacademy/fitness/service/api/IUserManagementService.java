package by.itacademy.fitness.service.api;


import by.itacademy.fitness.core.dto.UserCreateUpdateDTO;
import by.itacademy.fitness.core.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IUserManagementService {

    void create(UserCreateUpdateDTO userCreateUpdateDTO);

    Page<UserDTO> getPage(Pageable pageable);

    UserDTO get(UUID uuid);

    void update(UUID uuid, LocalDateTime updateDateTime, UserCreateUpdateDTO userCreateUpdateDTO);

}
