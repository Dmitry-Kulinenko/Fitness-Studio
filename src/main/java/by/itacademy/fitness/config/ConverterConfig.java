package by.itacademy.fitness.config;

import by.itacademy.fitness.core.converter.UserCreateUpdateDTOToEntityConverter;
import by.itacademy.fitness.core.converter.UserEntityToDTOConverter;
import by.itacademy.fitness.core.dto.UserCreateUpdateDTO;
import by.itacademy.fitness.core.dto.UserDTO;
import by.itacademy.fitness.dao.entity.User;
import by.itacademy.fitness.service.api.IRoleService;
import by.itacademy.fitness.service.api.IStatusService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConverterConfig {
    @Bean
    public Converter<UserCreateUpdateDTO, User> userToEntityConverter(IRoleService roleServise,
                                                                      IStatusService statusService) {
        return new UserCreateUpdateDTOToEntityConverter(roleServise, statusService);
    }

    @Bean
    public Converter<User, UserDTO> userEntityToDTOConverter() {
        return new UserEntityToDTOConverter();
    }
}
