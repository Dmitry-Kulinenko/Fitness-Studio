package by.itacademy.fitness.service.user.impl;

import by.itacademy.fitness.dao.user.entity.Status;
import by.itacademy.fitness.dao.user.entity.userenum.StatusEnum;
import by.itacademy.fitness.dao.user.repository.IStatusRepository;
import by.itacademy.fitness.service.user.api.IStatusService;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements IStatusService {
    private IStatusRepository statusRepository;

    public StatusService(IStatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status findStatusByName(String status) {
        return statusRepository.findByStatusName(StatusEnum.valueOf(status))
                .orElseThrow(IllegalArgumentException::new);
    }
}
