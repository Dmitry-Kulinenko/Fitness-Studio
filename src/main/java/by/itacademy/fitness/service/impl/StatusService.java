package by.itacademy.fitness.service.impl;

import by.itacademy.fitness.dao.entity.Status;
import by.itacademy.fitness.dao.repository.IStatusRepository;
import by.itacademy.fitness.service.api.IStatusService;

public class StatusService implements IStatusService {
    private IStatusRepository statusRepository;

    public StatusService() {
    }

    public StatusService(IStatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status findStatusByName(String status) {
        return statusRepository
                .findByStatusIgnoreCase(status)
                .orElseThrow(IllegalArgumentException::new);
    }
}
