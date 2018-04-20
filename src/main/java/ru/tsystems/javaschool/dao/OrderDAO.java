package ru.tsystems.javaschool.dao;

import ru.tsystems.javaschool.entity.Order;
import ru.tsystems.javaschool.entity.Vehicle;

public interface OrderDAO extends AbstractDAO<Order> {
    Order getByNumber(int number);
    int deleteByNumber(int number);
    void setVehicle(Order order, Vehicle vehicle);
}
