package by.itacademy.fitness.service.user.impl;

import by.itacademy.fitness.core.user.dto.UserDTO;
import by.itacademy.fitness.core.user.dto.UserDetailsDTO;
import by.itacademy.fitness.core.user.dto.UserLoginDTO;
import by.itacademy.fitness.core.user.dto.UserRegistrationDTO;
import by.itacademy.fitness.dao.user.entity.User;
import by.itacademy.fitness.dao.user.entity.userenum.StatusEnum;
import by.itacademy.fitness.dao.user.repository.IStatusRepository;
import by.itacademy.fitness.dao.user.repository.IUserRepository;
import by.itacademy.fitness.security.JwtTokenUtil;
import by.itacademy.fitness.security.UserHolder;
import by.itacademy.fitness.service.user.api.IEmailSendingService;
import by.itacademy.fitness.service.user.api.IUserPersonalAccountService;
import jakarta.transaction.Transactional;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserPersonalAccountService implements IUserPersonalAccountService {

    private final Converter<UserRegistrationDTO, User> registrationDTOToEntityConverter;
    private final Converter<User, UserDetailsDTO> entityToDetailsDTOConverter;
    private final Converter<User, UserDTO> userEntityToDTOConverter;
    private final PasswordEncoder passwordEncoder;
    private final UserHolder userHolder;
    private final JwtTokenUtil tokenUtil;
    private final IUserRepository userRepository;
    private final IStatusRepository statusRepository;
    private final IEmailSendingService emailSendingService;

    public UserPersonalAccountService(Converter<UserRegistrationDTO, User> registrationDTOToEntityConverter,
                                      Converter<User, UserDetailsDTO> entityToDetailsDTOConverter,
                                      Converter<User, UserDTO> userEntityToDTOConverter,
                                      PasswordEncoder passwordEncoder, UserHolder userHolder,
                                      JwtTokenUtil tokenUtil, IUserRepository userRepository,
                                      IStatusRepository statusRepository,
                                      IEmailSendingService emailSendingService) {
        this.registrationDTOToEntityConverter = registrationDTOToEntityConverter;
        this.entityToDetailsDTOConverter = entityToDetailsDTOConverter;
        this.userEntityToDTOConverter = userEntityToDTOConverter;
        this.passwordEncoder = passwordEncoder;
        this.userHolder = userHolder;
        this.tokenUtil = tokenUtil;
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
        this.emailSendingService = emailSendingService;
    }

    @Override
    @Transactional
    public void register(UserRegistrationDTO registrationDTO) {
        User user = registrationDTOToEntityConverter.convert(registrationDTO);
        userRepository.save(user);
        String message = "Here's your verification code " + user.getUuid();
        emailSendingService.send(registrationDTO.getMail(), message);
    }

    @Override
    public void verify(String code, String mail) {
        User user = userRepository.findByMail(mail).orElseThrow(() ->
                new IllegalArgumentException("user with this mail: " + mail
                        + " not found"));
        if (user.getUuid().toString().equals(code)) {
            user.setStatus(statusRepository.findByStatusName(StatusEnum.ACTIVATED).orElseThrow(
                    () -> new IllegalArgumentException("Status not found")
            ));
            userRepository.save(user);
        } else {
            throw new RuntimeException("invalid verification code");
        }
    }

    @Override
    public String login(UserLoginDTO user) {
        User entity = userRepository.findByMail(user.getMail()).orElseThrow(() ->
                new IllegalArgumentException("user with email: " + user.getMail()
                        + " not found"));
        if (entity.getStatus().getStatusName() == StatusEnum.WAITING_ACTIVATION) {
            throw new IllegalArgumentException("authorization is not available," +
                    " the account is not verified");
        }
        if (passwordEncoder.matches(user.getPassword(), entity.getPassword())) {
            UserDetailsDTO userDetails = entityToDetailsDTOConverter.convert(entity);
            return tokenUtil.generateAccessToken(userDetails);
        } else {
            throw new IllegalArgumentException("invalid password");
        }
    }

    @Override
    public UserDTO getPersonalData() {
        User user = userRepository.findByMail(
                        userHolder.getUser().getUsername())
                .orElseThrow(() ->
                        new IllegalArgumentException("User with this email not found"));
        return userEntityToDTOConverter.convert(user);
    }

}
