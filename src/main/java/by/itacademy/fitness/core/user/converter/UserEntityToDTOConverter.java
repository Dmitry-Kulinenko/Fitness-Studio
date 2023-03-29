package by.itacademy.fitness.core.user.converter;

import by.itacademy.fitness.core.user.dto.UserDTO;
import by.itacademy.fitness.dao.user.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserEntityToDTOConverter implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(User source) {
        return new UserDTO(source.getUuid(),
                source.getCreationDateTime(),
                source.getUpdateDateTime(),
                source.getMail(),
                source.getPassword(),
                source.getFullName(),
                source.getRole(),
                source.getStatus());
    }
}
