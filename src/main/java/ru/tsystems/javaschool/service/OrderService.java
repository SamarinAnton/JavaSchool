package ru.tsystems.javaschool.service;

import ru.tsystems.javaschool.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAll();
    OrderDTO getById(int id);
    int add(OrderDTO order);
    int needCapacity(int number);
    int spendTime(int number);
    OrderDTO getByNumber(int number);
}
