package by.itacademy.fitness.service.impl;

import by.itacademy.fitness.core.dto.UserCreateUpdateDTO;
import by.itacademy.fitness.core.dto.UserDTO;
import by.itacademy.fitness.dao.entity.Role;
import by.itacademy.fitness.dao.entity.Status;
import by.itacademy.fitness.dao.entity.User;
import by.itacademy.fitness.dao.repository.IUserManagementRepository;
import by.itacademy.fitness.service.api.IRoleService;
import by.itacademy.fitness.service.api.IStatusService;
import by.itacademy.fitness.service.api.IUserManagementService;
import jakarta.persistence.OptimisticLockException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserManagementService implements IUserManagementService {
    private IUserManagementRepository userManagementRepository;
    private IRoleService roleService;
    private IStatusService statusService;

    private Converter<UserCreateUpdateDTO, User> userCreateDTOtoEntityConverter;
    private Converter<User, UserDTO> userEntityToDTOConverter;

    public UserManagementService(IUserManagementRepository userManagementRepository,
                                 IRoleService roleService,
                                 IStatusService statusService,
                                 Converter<UserCreateUpdateDTO, User> userCreateDTOtoEntityConverter,
                                 Converter<User, UserDTO> userEntityToDTOConverter) {
        this.userManagementRepository = userManagementRepository;
        this.roleService = roleService;
        this.statusService = statusService;
        this.userCreateDTOtoEntityConverter = userCreateDTOtoEntityConverter;
        this.userEntityToDTOConverter = userEntityToDTOConverter;
    }

    @Override
    public void create(UserCreateUpdateDTO userCreateUpdateDTO) {
        userManagementRepository.save(
                userCreateDTOtoEntityConverter.convert(userCreateUpdateDTO));
    }

    @Override
    public Page<UserDTO> getPage(Pageable pageable) {
        Page<User> userPage = userManagementRepository.findAll(pageable);
        return userPage.map(userEntityToDTOConverter::convert);
    }

    @Override
    public UserDTO get(UUID uuid) {
        User user = userManagementRepository.findById(uuid).orElseThrow(IllegalArgumentException::new);//FIXME
        return userEntityToDTOConverter.convert(user);
    }

    @Override
    public void update(UUID uuid, LocalDateTime updateDateTime, UserCreateUpdateDTO userCreateDTO) {
        User user = userManagementRepository.findById(uuid)
                .orElseThrow(IllegalArgumentException::new);

        if (!updateDateTime.equals(user.getUpdateDateTime())) {
            throw new OptimisticLockException("User with id '" + user.getUuid()
                    + "' has already been modified!");
        }

        Role role = roleService.findRoleByName(userCreateDTO.getRole());
        Status status = statusService.findStatusByName(userCreateDTO.getStatus());

        user.setMail(userCreateDTO.getMail());
        user.setRole(role);
        user.setPassword(user.getPassword());//FIXME
        user.setFullName(userCreateDTO.getFullName());
        user.setStatus(status);
        userManagementRepository.save(user);
    }
}

