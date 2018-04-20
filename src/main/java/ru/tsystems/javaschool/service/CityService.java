package ru.tsystems.javaschool.service;

import ru.tsystems.javaschool.dto.CityDTO;

import java.util.List;

public interface CityService {
    List<CityDTO> getAll();
    CityDTO getById(int id);
    CityDTO getByName(String name);
    int add(CityDTO city);
    double distance(String name1, String name2);
}
