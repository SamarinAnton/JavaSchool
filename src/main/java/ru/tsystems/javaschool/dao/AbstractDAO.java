package ru.tsystems.javaschool.dao;

import java.util.List;

public interface AbstractDAO<E> {
    List<E> getAll();
    E getById(int id);
    void insert(E entity);
    void update(E entity);
    int deleteById(int id);
}
