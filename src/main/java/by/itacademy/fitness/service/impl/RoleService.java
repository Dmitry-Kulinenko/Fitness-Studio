package by.itacademy.fitness.service.impl;

import by.itacademy.fitness.dao.entity.Role;
import by.itacademy.fitness.dao.repository.IRoleRepository;
import by.itacademy.fitness.service.api.IRoleService;

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
