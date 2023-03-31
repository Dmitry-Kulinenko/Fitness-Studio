package by.itacademy.fitness.security;

import by.itacademy.fitness.core.user.dto.UserDetailsDTO;
import by.itacademy.fitness.dao.user.entity.User;
import by.itacademy.fitness.dao.user.repository.IUserRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final IUserRepository userRepository;
    private final Converter<User, UserDetailsDTO> converter;

    public CustomUserDetailsService(IUserRepository userRepository,
                                    Converter<User, UserDetailsDTO> converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return converter.convert(
                userRepository.findByMail(username).orElseThrow(
                        IllegalArgumentException::new
                )
        );
    }
}
