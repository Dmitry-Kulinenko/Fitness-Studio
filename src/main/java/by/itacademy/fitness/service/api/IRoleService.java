package by.itacademy.fitness.service.api;

import by.itacademy.fitness.dao.entity.Role;

public interface IRoleService {
    Role findRoleByName(String role);
}
