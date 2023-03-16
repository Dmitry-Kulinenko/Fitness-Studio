package by.itacademy.fitness.service.api;

import by.itacademy.fitness.dao.entity.Status;

public interface IStatusService {
    Status findStatusByName(String status);
}
