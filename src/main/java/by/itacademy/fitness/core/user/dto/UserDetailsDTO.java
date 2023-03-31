package by.itacademy.fitness.core.user.dto;

import by.itacademy.fitness.dao.user.entity.Role;
import by.itacademy.fitness.dao.user.entity.Status;
import by.itacademy.fitness.dao.user.entity.userenum.StatusEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

public class UserDetailsDTO implements UserDetails {
    private UUID userId;
    private String mail;
    private String fullName;
    private String password;
    private Status status;
    private Role role;

    public UserDetailsDTO() {
    }

    public UserDetailsDTO(UUID userId,
                          String mail,
                          String fullName,
                          String password,
                          Status status,
                          Role role) {
        this.userId = userId;
        this.mail = mail;
        this.fullName = fullName;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getMail() {
        return mail;
    }

    public String getFullName() {
        return fullName;
    }

    public Status getStatus() {
        return status;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return status.getStatusName() == StatusEnum.DEACTIVATED;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status.getStatusName() == StatusEnum.DEACTIVATED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return status.getStatusName() == StatusEnum.ACTIVATED;
    }
}
