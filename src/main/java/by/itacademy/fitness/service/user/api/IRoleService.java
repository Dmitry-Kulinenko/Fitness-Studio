package by.itacademy.fitness.service.user.api;

import by.itacademy.fitness.dao.user.entity.Role;

public interface IRoleService {
    Role findRoleByName(String role);
}
