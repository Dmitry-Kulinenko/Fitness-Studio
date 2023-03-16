package by.itacademy.fitness.core.dto;

import by.itacademy.fitness.dao.entity.Role;
import by.itacademy.fitness.dao.entity.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonPropertyOrder({
        "uuid",
        "dt_create",
        "dt_update",
        "mail",
        "fio",
        "role",
        "status"
})
public class UserDTO {
    private UUID uuid;
    private LocalDateTime creationDateTime;
    private LocalDateTime updateDateTime;
    private String mail;
    private String fullName;
    @JsonUnwrapped
    private Role role;
    @JsonUnwrapped
    private Status status;


    public UserDTO() {
    }

    public UserDTO(UUID uuid,
                   LocalDateTime creationDateTime,
                   LocalDateTime updateDateTime,
                   String mail,
                   String password,
                   String fullName,
                   Role role,
                   Status status) {
        this.uuid = uuid;
        this.creationDateTime = creationDateTime;
        this.updateDateTime = updateDateTime;
        this.mail = mail;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("dt_create")
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    @JsonProperty("dt_create")
    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    @JsonProperty("dt_update")
    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    @JsonProperty("dt_update")
    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
