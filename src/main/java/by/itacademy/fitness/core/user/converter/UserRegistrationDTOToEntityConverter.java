package by.itacademy.fitness.core.user.converter;

import by.itacademy.fitness.core.user.dto.UserRegistrationDTO;
import by.itacademy.fitness.dao.user.entity.Role;
import by.itacademy.fitness.dao.user.entity.Status;
import by.itacademy.fitness.dao.user.entity.User;
import by.itacademy.fitness.service.user.api.IRoleService;
import by.itacademy.fitness.service.user.api.IStatusService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationDTOToEntityConverter implements Converter<UserRegistrationDTO, User> {
    private IRoleService roleService;
    private IStatusService statusService;
    private String USER_ROLE = "USER";
    private String NEW_USER_STATUS = "WAITING_ACTIVATION";

    public UserRegistrationDTOToEntityConverter(IRoleService roleService, IStatusService statusService) {
        this.roleService = roleService;
        this.statusService = statusService;
    }

    @Override
    public User convert(UserRegistrationDTO source) {
        Role role = roleService.findRoleByName(USER_ROLE);
        Status status = statusService.findStatusByName(NEW_USER_STATUS);

        return new User(source.getMail(), source.getPassword(), source.getFullName(), role, status);
    }
}
