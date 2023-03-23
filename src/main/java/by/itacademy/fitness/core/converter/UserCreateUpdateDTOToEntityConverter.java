package by.itacademy.fitness.core.converter;

import by.itacademy.fitness.core.dto.UserCreateUpdateDTO;
import by.itacademy.fitness.dao.entity.Role;
import by.itacademy.fitness.dao.entity.Status;
import by.itacademy.fitness.dao.entity.User;
import by.itacademy.fitness.service.api.IRoleService;
import by.itacademy.fitness.service.api.IStatusService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserCreateUpdateDTOToEntityConverter implements Converter<UserCreateUpdateDTO, User> {

    //    private PasswordEncoder passwordEncoder
    private IRoleService roleService;
    private IStatusService statusService;

    public UserCreateUpdateDTOToEntityConverter(IRoleService roleService,
                                                IStatusService statusService) {
        this.roleService = roleService;
        this.statusService = statusService;
    }

    @Override
    public User convert(UserCreateUpdateDTO userCreateUpdateDTO) {
        Role role = roleService.findRoleByName(userCreateUpdateDTO.getRole());
        Status status = statusService.findStatusByName(userCreateUpdateDTO.getStatus());

        return new User(userCreateUpdateDTO.getMail(),
                userCreateUpdateDTO.getPassword(),
                userCreateUpdateDTO.getFullName(),
                role,
                status);
    }
}