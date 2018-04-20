package ru.tsystems.javaschool.service;

import ru.tsystems.javaschool.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    List<DriverDTO> getAll();
    DriverDTO getById(int id);
    int add(DriverDTO driver);
    void update(DriverDTO driver);
    DriverDTO getByNumber(String number);
    int removeByNumber(String number);
    //int addDriverWithAccount(DriverDTO driverDTO, String number, String password);
}
