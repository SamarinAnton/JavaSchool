package ru.tsystems.javaschool.dao;

import ru.tsystems.javaschool.entity.Driver;

public interface DriverDAO extends AbstractDAO<Driver> {
    Driver getByNumber(String number);
    int deleteByNumber(String number);
}
