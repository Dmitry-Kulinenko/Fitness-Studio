package by.itacademy.fitness.service.impl;

import by.itacademy.fitness.core.dto.UserCreateUpdateDTO;
import by.itacademy.fitness.core.dto.UserDTO;
import by.itacademy.fitness.dao.entity.Role;
import by.itacademy.fitness.dao.entity.Status;
import by.itacademy.fitness.dao.entity.User;
import by.itacademy.fitness.dao.repository.IUserRepository;
import by.itacademy.fitness.service.api.IRoleService;
import by.itacademy.fitness.service.api.IStatusService;
import by.itacademy.fitness.service.api.IUserManagementService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserManagementService implements IUserManagementService {
    private IUserRepository userRepository;
    private IRoleService roleService;
    private IStatusService statusService;

    private Converter<UserCreateUpdateDTO, User> userCreateDTOtoEntityConverter;
    private Converter<User, UserDTO> userEntityToDTOConverter;

    public UserManagementService(IUserRepository userManagementRepository,
                                 IRoleService roleService,
                                 IStatusService statusService,
                                 Converter<UserCreateUpdateDTO, User> userCreateDTOtoEntityConverter,
                                 Converter<User, UserDTO> userEntityToDTOConverter) {
        this.userRepository = userManagementRepository;
        this.roleService = roleService;
        this.statusService = statusService;
        this.userCreateDTOtoEntityConverter = userCreateDTOtoEntityConverter;
        this.userEntityToDTOConverter = userEntityToDTOConverter;
    }

    @Override
    public void create(UserCreateUpdateDTO userCreateUpdateDTO) {
        userRepository.save(
                userCreateDTOtoEntityConverter.convert(userCreateUpdateDTO));
    }

    @Override
    public Page<UserDTO> getPage(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(userEntityToDTOConverter::convert);
    }

    @Override
    public UserDTO get(UUID uuid) {
        User user = userRepository.findById(uuid).orElseThrow(IllegalArgumentException::new);//FIXME
        return userEntityToDTOConverter.convert(user);
    }

    @Override
    public void update(UUID uuid, LocalDateTime updateDateTime, UserCreateUpdateDTO userUpdateDTO) {
        Role role = roleService.findRoleByName(userUpdateDTO.getRole());
        Status status = statusService.findStatusByName(userUpdateDTO.getStatus());

        userRepository.updateUserData(userUpdateDTO.getMail(),
                userUpdateDTO.getPassword(),
                userUpdateDTO.getFullName(),
                role,
                status,
                uuid,
                updateDateTime
        );

    }
}

