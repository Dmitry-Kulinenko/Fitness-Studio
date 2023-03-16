package by.itacademy.fitness.service.impl;

import by.itacademy.fitness.core.dto.UserCreateUpdateDTO;
import by.itacademy.fitness.core.dto.UserDTO;
import by.itacademy.fitness.dao.entity.User;
import by.itacademy.fitness.dao.repository.IUserManagementRepository;
import by.itacademy.fitness.service.api.IUserManagementService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserManagementService implements IUserManagementService {
    private IUserManagementRepository userManagementRepository;

    private Converter<UserCreateUpdateDTO, User> userCreateDTOtoEntityConverter;
    private Converter<User, UserDTO> userEntityToDTOConverter;

    public UserManagementService(IUserManagementRepository userManagementRepository,
                                 Converter<UserCreateUpdateDTO, User> userCreateDTOtoEntityConverter,
                                 Converter<User, UserDTO> userEntityToDTOConverter) {
        this.userManagementRepository = userManagementRepository;
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
//        userManagementRepository.updateUpdateDateTimeAndMailAndPasswordAndFullNameAndRoleAndStatusByUuid(
//                updateDateTime,
//                userCreateDTO.getMail(),
//                userCreateDTO.getPassword(),
//                userCreateDTO.getFullName(),
//                userCreateDTO.getRole(),
//                userCreateDTO.getStatus(),
//                uuid);
    }
}
