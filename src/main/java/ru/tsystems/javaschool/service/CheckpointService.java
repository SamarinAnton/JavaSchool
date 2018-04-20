package ru.tsystems.javaschool.service;

import ru.tsystems.javaschool.dto.CheckpointDTO;

import java.util.List;

public interface CheckpointService {
    List<CheckpointDTO> getAll();
    CheckpointDTO getById(int id);
}
