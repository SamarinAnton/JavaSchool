package ru.tsystems.javaschool.service;

import ru.tsystems.javaschool.dto.SubtaskDTO;

import java.util.List;

public interface SubtaskService {
    List<SubtaskDTO> getAll();
    SubtaskDTO getById(int id);
}
