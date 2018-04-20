package ru.tsystems.javaschool.dao;

import ru.tsystems.javaschool.entity.City;

public interface CityDAO extends AbstractDAO<City> {
    City getByName(String name);
    int deleteByName(String name);  //remove?
}
