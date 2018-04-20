package ru.tsystems.javaschool.service;

import ru.tsystems.javaschool.dto.CargoDTO;

import java.util.List;

public interface CargoService {
    void update(CargoDTO cargo);
    void add(CargoDTO cargo);
    CargoDTO getById(int id);
    List<CargoDTO> getAll();
}
