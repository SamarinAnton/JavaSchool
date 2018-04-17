package ru.tsystems.javaschool.dto;

import ru.tsystems.javaschool.entity.User;

import java.util.Objects;

public class UserDTO extends AbstractDTO<User> {

    private String login;
    private String password;
    private User.Status status;

    public UserDTO() {
    }

    public UserDTO(int id, String login, String password, User.Status status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.login = entity.getLogin();
        this.password = entity.getPassword();
        this.status = entity.getStatus();
    }

    @Override
    public void apply(User entity) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User.Status getStatus() {
        return status;
    }

    public void setStatus(User.Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO user = (UserDTO) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                status.equals(user.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, status);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", status=" + status +
                '}';
    }
}
