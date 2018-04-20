package ru.tsystems.javaschool.dao;

import ru.tsystems.javaschool.entity.City;
import ru.tsystems.javaschool.entity.Driver;
import ru.tsystems.javaschool.entity.Vehicle;

public interface DriverDAO extends AbstractDAO<Driver> {
    Driver getByNumber(String number);
    int  deleteByNumber(String number);
    void move(Driver driver, City city);
    void setVehicle(Driver driver, Vehicle vehicle);
}
