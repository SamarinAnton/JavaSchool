package ru.tsystems.javaschool.dao;

import ru.tsystems.javaschool.entity.Cargo;

public interface CargoDAO extends AbstractDAO<Cargo> {
    int deleteByNumber(int number);
}
