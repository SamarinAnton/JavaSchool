package ru.tsystems.javaschool.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.CheckpointDAO;
import ru.tsystems.javaschool.dto.CheckpointDTO;
import ru.tsystems.javaschool.entity.Checkpoint;
import ru.tsystems.javaschool.service.CheckpointService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckpointServiceImpl implements CheckpointService{
    private CheckpointDAO checkpointDAO;

    @Autowired
    public CheckpointServiceImpl(CheckpointDAO checkpointDAO) {
        this.checkpointDAO = checkpointDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<CheckpointDTO> getAll() {
        return checkpointDAO.getAll().stream()
                .map(x -> {
                    CheckpointDTO checkpointDTO = new CheckpointDTO(x);
                    checkpointDTO.apply(x);
                    return checkpointDTO;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public CheckpointDTO getById(int id) {
        Checkpoint checkpoint = checkpointDAO.getById(id);
        CheckpointDTO checkpointDTO = new CheckpointDTO(checkpoint);
        checkpointDTO.apply(checkpoint);
        return checkpointDTO;
    }
}
