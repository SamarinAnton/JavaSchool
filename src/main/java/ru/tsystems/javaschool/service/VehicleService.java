package ru.tsystems.javaschool.service;

import ru.tsystems.javaschool.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    List<VehicleDTO> getAll();
    VehicleDTO getById(int id);
    VehicleDTO getByNumber(String number);
    void update(VehicleDTO vehicle);
    void add(VehicleDTO vehicle);
    double speed();
}
