package by.itacademy.fitness.service.user.api;

import by.itacademy.fitness.dao.user.entity.Status;

public interface IStatusService {
    Status findStatusByName(String status);
}
