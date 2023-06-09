package by.itacademy.fitness.core.user.dto;

import by.itacademy.fitness.core.timeconverter.json.LocalDateTimeToLong;
import by.itacademy.fitness.core.timeconverter.json.LongToLocalDateTime;
import by.itacademy.fitness.dao.user.entity.Role;
import by.itacademy.fitness.dao.user.entity.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
    @JsonSerialize(converter = LocalDateTimeToLong.class)
    @JsonDeserialize(converter = LongToLocalDateTime.class)
    private LocalDateTime creationDateTime;
    @JsonSerialize(converter = LocalDateTimeToLong.class)
    @JsonDeserialize(converter = LongToLocalDateTime.class)
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

    @JsonProperty("dt_update")
    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
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

    public Role getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }

}
