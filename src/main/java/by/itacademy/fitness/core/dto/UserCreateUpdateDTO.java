package by.itacademy.fitness.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "mail",
        "fio",
        "role",
        "status",
        "password"
})
public class UserCreateUpdateDTO {
    private String mail;
    private String fullName;
    private String role;
    private String status;
    private String password;

    public UserCreateUpdateDTO() {
    }

    public UserCreateUpdateDTO(String mail, String fullName, String role, String status, String password) {
        this.mail = mail;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}