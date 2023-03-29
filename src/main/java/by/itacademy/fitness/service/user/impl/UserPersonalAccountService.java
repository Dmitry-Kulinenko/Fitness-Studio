package by.itacademy.fitness.service.user.impl;

import by.itacademy.fitness.core.user.dto.UserDTO;
import by.itacademy.fitness.core.user.dto.UserLoginDTO;
import by.itacademy.fitness.core.user.dto.UserRegistrationDTO;
import by.itacademy.fitness.dao.user.repository.IUserRepository;
import by.itacademy.fitness.service.user.api.IUserPersonalAccountService;

public class UserPersonalAccountService implements IUserPersonalAccountService {

    private IUserRepository userRepository;

    public UserPersonalAccountService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserRegistrationDTO userRegistrationDTO) {

    }

    @Override
    public void verify(String code, String mail) {

    }

    @Override
    public String login(UserLoginDTO userLoginDTO) {
        return null;
    }

    @Override
    public UserDTO getPersonalData() {
        return null;
    }
}
