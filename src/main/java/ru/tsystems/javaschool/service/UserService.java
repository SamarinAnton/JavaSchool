package ru.tsystems.javaschool.service;

import ru.tsystems.javaschool.dto.UserDTO;

public interface UserService {
    UserDTO getById(int id);
    UserDTO getByLogin(String login);
    int add(UserDTO user);
    void update(UserDTO user);
}
