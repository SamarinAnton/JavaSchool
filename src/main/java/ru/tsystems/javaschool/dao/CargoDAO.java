package ru.tsystems.javaschool.dao;

import ru.tsystems.javaschool.entity.Cargo;

public interface CargoDAO extends AbstractDAO<Cargo> {
    Cargo getByNumber(int number);
    int deleteByNumber(int number); //removed?
}
