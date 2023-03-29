package by.itacademy.fitness.service.user.api;

import by.itacademy.fitness.core.user.dto.UserDTO;
import by.itacademy.fitness.core.user.dto.UserLoginDTO;
import by.itacademy.fitness.core.user.dto.UserRegistrationDTO;

public interface IUserPersonalAccountService {
    void register(UserRegistrationDTO userRegistrationDTO);

    void verify(String code, String mail);

    String login(UserLoginDTO userLoginDTO);

    UserDTO getPersonalData();
}
