package ru.tsystems.javaschool.service;

import ru.tsystems.javaschool.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAll();
    OrderDTO getById(int id);
    void add(OrderDTO order);
    void update(OrderDTO order);
    int needCapacity(int id);
    double spendTime(int id);
    OrderDTO getByNumber(int number);
}
