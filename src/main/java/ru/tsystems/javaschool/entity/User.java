package ru.tsystems.javaschool.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "trucking")
public class User {

    public enum Status {DRIVER, ADMIN}

    private int id;
    private String login;
    private String password;
    private Status status;

    public User() {
    }

    public User(int id, String login, String password, Status status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 45, unique = true)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Basic
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
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
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", status=" + status +
                '}';
    }
}
