package by.itacademy.fitness.service.user.api;


import by.itacademy.fitness.core.user.dto.UserCreateUpdateDTO;
import by.itacademy.fitness.core.user.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IUserManagementService {

    void add(UserCreateUpdateDTO userCreateUpdateDTO);

    Page<UserDTO> getPage(Pageable pageable);

    UserDTO get(UUID uuid);

    void update(UUID uuid, LocalDateTime updateDateTime, UserCreateUpdateDTO userCreateUpdateDTO);

}
