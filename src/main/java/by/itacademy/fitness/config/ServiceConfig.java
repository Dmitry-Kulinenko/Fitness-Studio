package by.itacademy.fitness.config;

import by.itacademy.fitness.core.dto.UserCreateUpdateDTO;
import by.itacademy.fitness.core.dto.UserDTO;
import by.itacademy.fitness.dao.entity.User;
import by.itacademy.fitness.dao.repository.IRoleRepository;
import by.itacademy.fitness.dao.repository.IStatusRepository;
import by.itacademy.fitness.dao.repository.IUserManagementRepository;
import by.itacademy.fitness.service.api.IRoleService;
import by.itacademy.fitness.service.api.IStatusService;
import by.itacademy.fitness.service.api.IUserManagementService;
import by.itacademy.fitness.service.impl.RoleService;
import by.itacademy.fitness.service.impl.StatusService;
import by.itacademy.fitness.service.impl.UserManagementService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ServiceConfig {

    @Bean
    public IUserManagementService userManagementService(IUserManagementRepository userManagementRepository,
                                                        IRoleService roleService,
                                                        IStatusService statusService,
                                                        Converter<UserCreateUpdateDTO, User> userCreateDTOtoEntityConverter,
                                                        Converter<User, UserDTO> userEntityToDTOConverter) {
        return new UserManagementService(userManagementRepository,
                roleService,
                statusService,
                userCreateDTOtoEntityConverter,
                userEntityToDTOConverter);
    }

    @Bean
    IRoleService roleService(IRoleRepository roleRepository) {
        return new RoleService(roleRepository);
    }

    @Bean
    IStatusService statusRepository(IStatusRepository statusRepository) {
        return new StatusService(statusRepository);
    }
}
