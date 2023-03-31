package by.itacademy.fitness.core.user.converter;

import by.itacademy.fitness.core.user.dto.UserCreateUpdateDTO;
import by.itacademy.fitness.dao.user.entity.Role;
import by.itacademy.fitness.dao.user.entity.Status;
import by.itacademy.fitness.dao.user.entity.User;
import by.itacademy.fitness.service.user.api.IRoleService;
import by.itacademy.fitness.service.user.api.IStatusService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCreateUpdateDTOToEntityConverter implements Converter<UserCreateUpdateDTO, User> {

    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;
    private final IStatusService statusService;

    public UserCreateUpdateDTOToEntityConverter(PasswordEncoder passwordEncoder,
                                                IRoleService roleService,
                                                IStatusService statusService) {
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.statusService = statusService;
    }

    @Override
    public User convert(UserCreateUpdateDTO userCreateUpdateDTO) {
        Role role = roleService.findRoleByName(userCreateUpdateDTO.getRole());
        Status status = statusService.findStatusByName(userCreateUpdateDTO.getStatus());
        String password = passwordEncoder.encode(userCreateUpdateDTO.getPassword());

        return new User(userCreateUpdateDTO.getMail(),
                password,
                userCreateUpdateDTO.getFullName(),
                role,
                status);
    }
}