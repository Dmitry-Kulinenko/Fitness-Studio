package by.itacademy.fitness.dao.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
@Table(schema = "fitness", name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID uuid;
    @Column(name = "dt_create")
    private LocalDateTime creationDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    @Version
    @Column(name = "dt_update")
    private LocalDateTime updateDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

    private String mail;
    private String password;
    @Column(name = "fio")
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;

    public User() {
    }


    public User(String mail, String password, String fullName,
                Role role, Status status) {
        this.mail = mail;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
        LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

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
