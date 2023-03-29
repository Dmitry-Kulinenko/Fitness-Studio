package by.itacademy.fitness.core.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Email;

@JsonPropertyOrder({
        "mail",
        "fio",
        "password"
})
public class UserRegistrationDTO {

    @Email
    private String mail;
    private String fullName;
    private String password;

    public UserRegistrationDTO(String mail, String fullName,
                               String password) {
        this.mail = mail;
        this.fullName = fullName;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @JsonProperty("fio")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fio")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}