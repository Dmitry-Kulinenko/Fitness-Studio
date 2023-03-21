package by.itacademy.fitness.service.api;

import by.itacademy.fitness.core.dto.UserDTO;
import by.itacademy.fitness.core.dto.UserLoginDTO;
import by.itacademy.fitness.core.dto.UserRegistrationDTO;

public interface IUserPersonalAccountService {
    void register(UserRegistrationDTO userRegistrationDTO);

    void verify(String code, String mail);

    String login(UserLoginDTO userLoginDTO);

    UserDTO getPersonalData();
}
