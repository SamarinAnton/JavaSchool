package ru.tsystems.javaschool.service;

import ru.tsystems.javaschool.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO getById(int id);
    UserDTO getByLogin(String login);
    int add(UserDTO user);
    void update(UserDTO user);
}
