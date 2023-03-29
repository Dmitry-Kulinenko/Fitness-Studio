package by.itacademy.fitness.service.user.impl;

import by.itacademy.fitness.dao.user.entity.Role;
import by.itacademy.fitness.dao.user.repository.IRoleRepository;
import by.itacademy.fitness.service.user.api.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    private IRoleRepository roleRepository;

    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleByName(String role) {
        return roleRepository
                .findByRoleIgnoreCase(role)
                .orElseThrow(IllegalArgumentException::new);
    }
}
