package by.itacademy.fitness.core.user.dto;

import jakarta.validation.constraints.NotBlank;

public class UserLoginDTO {
    @NotBlank(message = "Mail couldn't be blank")
    private final String mail;
    @NotBlank(message = "Password couldn't be blank")
    private final String password;

    public UserLoginDTO(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
