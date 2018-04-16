package ru.tsystems.javaschool.dao;

import ru.tsystems.javaschool.entity.User;

public interface UserDAO extends AbstractDAO<User> {
    User getByLogin(String login);
    int deleteByLogin(String login);
}
