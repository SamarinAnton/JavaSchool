package ru.tsystems.javaschool.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "drivers", schema = "trucking")
public class Driver {

    public enum Status {REST, WORK}

    private int id;
    private String firstName;
    private String lastName;
    private String number;
    private Timestamp update = Timestamp.valueOf(LocalDateTime.now());
    private int worked;
    private Status status = Status.REST;
    private City city;
    private User user;
    private Order order;
    private Vehicle vehicle;

    public Driver() {
    }

    public Driver(int id, String number, String firstName, String lastName
            , Status status, Timestamp update, int worked, City city
            , Vehicle vehicle, User user) {
        this.id = id;
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.update = update;
        this.worked = worked;
        this.city = city;
        this.vehicle = vehicle;
        this.user = user;
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
    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 45, unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    @Basic
    @Column(name = "update", nullable = false)
    public Timestamp getUpdate() {
        return update;
    }

    public void setUpdate(Timestamp update) {
        this.update = update;
    }

    @Basic
    @Column(name = "worked", nullable = false)
    public int getWorked() {
        return worked;
    }

    public void setWorked(int worked) {
        this.worked = worked;
    }

    @ManyToOne
    @JoinColumn(name = "cities_id", referencedColumnName = "id", nullable = false)
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name = "vehicles_id", referencedColumnName = "id")
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id &&
                worked == driver.worked &&
                Objects.equals(firstName, driver.firstName) &&
                Objects.equals(lastName, driver.lastName) &&
                Objects.equals(number, driver.number) &&
                Objects.equals(update, driver.update) &&
                status.equals(driver.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, number, update, worked, status);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", lastStatusUpdate=" + update +
                ", workedThisMonthMs=" + worked +
                '}';
    }
}
