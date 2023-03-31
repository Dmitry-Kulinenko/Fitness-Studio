package by.itacademy.fitness.core.user.converter;

import by.itacademy.fitness.core.user.dto.UserRegistrationDTO;
import by.itacademy.fitness.dao.user.entity.Role;
import by.itacademy.fitness.dao.user.entity.Status;
import by.itacademy.fitness.dao.user.entity.User;
import by.itacademy.fitness.dao.user.entity.userenum.RoleEnum;
import by.itacademy.fitness.dao.user.entity.userenum.StatusEnum;
import by.itacademy.fitness.service.user.api.IRoleService;
import by.itacademy.fitness.service.user.api.IStatusService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationDTOToEntityConverter implements Converter<UserRegistrationDTO, User> {
    private final IRoleService roleService;
    private final IStatusService statusService;
    private final PasswordEncoder passwordEncoder;

    public UserRegistrationDTOToEntityConverter(IRoleService roleService,
                                                IStatusService statusService,
                                                PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.statusService = statusService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User convert(UserRegistrationDTO source) {
        Role role = roleService.findRoleByName(RoleEnum.USER.name());
        Status status = statusService.findStatusByName(StatusEnum.WAITING_ACTIVATION.name());
        String password = passwordEncoder.encode(source.getPassword());
        return new User(source.getMail(), password, source.getFullName(), role, status);
    }
}
