package by.itacademy.fitness.service.user.impl;

import by.itacademy.fitness.core.user.dto.UserCreateUpdateDTO;
import by.itacademy.fitness.core.user.dto.UserDTO;
import by.itacademy.fitness.dao.user.entity.Role;
import by.itacademy.fitness.dao.user.entity.Status;
import by.itacademy.fitness.dao.user.entity.User;
import by.itacademy.fitness.dao.user.repository.IUserRepository;
import by.itacademy.fitness.service.user.api.IRoleService;
import by.itacademy.fitness.service.user.api.IStatusService;
import by.itacademy.fitness.service.user.api.IUserManagementService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    public void add(UserCreateUpdateDTO userCreateUpdateDTO) {
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
        userRepository.updateUser(
                userUpdateDTO.getMail(), userUpdateDTO.getPassword(),
                userUpdateDTO.getFullName(), role, status,
                LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),
                uuid, updateDateTime);
    }
}

