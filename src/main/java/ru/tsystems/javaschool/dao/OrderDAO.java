package ru.tsystems.javaschool.dao;

import ru.tsystems.javaschool.entity.Order;

public interface OrderDAO extends AbstractDAO<Order> {
    Order getByNumber(int number);
    int deleteByNumber(int number);
}
