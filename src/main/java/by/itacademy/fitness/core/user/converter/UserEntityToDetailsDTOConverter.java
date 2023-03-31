package by.itacademy.fitness.core.user.converter;

import by.itacademy.fitness.core.user.dto.UserDetailsDTO;
import by.itacademy.fitness.dao.user.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserEntityToDetailsDTOConverter implements Converter<User, UserDetailsDTO> {
    @Override
    public UserDetailsDTO convert(User source) {
        return new UserDetailsDTO(
                source.getUuid(),
                source.getMail(),
                source.getFullName(),
                source.getPassword(),
                source.getStatus(),
                source.getRole()
        );
    }
}
