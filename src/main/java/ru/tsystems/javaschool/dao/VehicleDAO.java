package ru.tsystems.javaschool.dao;

import ru.tsystems.javaschool.entity.Vehicle;

public interface VehicleDAO extends AbstractDAO<Vehicle> {
    Vehicle getByNumber(String number);
    int deleteByNumber(String number);
}
