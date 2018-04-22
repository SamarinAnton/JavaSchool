package ru.tsystems.javaschool.dto;

import ru.tsystems.javaschool.entity.Driver;
import ru.tsystems.javaschool.entity.Order;
import ru.tsystems.javaschool.entity.User;

import java.sql.Timestamp;
import java.util.Objects;

public class DriverDTO extends AbstractDTO<Driver> {

    private String number;
    private String firstName;
    private String lastName;
    private Driver.Status status;
    private Timestamp lastUpdate;
    private int worked;

    private CityDTO city;
    private VehicleDTO vehicle;
    private UserDTO user;
    private OrderDTO order;

    public DriverDTO() {
    }

    public DriverDTO(String number) {
        this.number = number;
    }

    public DriverDTO(Driver entity) {
        this.id = entity.getId();
        this.number = entity.getNumber();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.status = entity.getStatus();
        this.worked = entity.getWorked();
        this.lastUpdate = entity.getUpdate();
        this.city = null;
        this.vehicle = null;
        this.user = null;
        this.order = null;
    }

    public DriverDTO(String number, String firstName, String lastName,
                     CityDTO city, VehicleDTO vehicle, Driver.Status status) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.vehicle = vehicle;
        this.status = status;
    }

    public DriverDTO(int id, String number, String firstName, String lastName,
                     CityDTO city, VehicleDTO vehicle, Driver.Status status,
                     Timestamp update, int worked) {
        this.id = id;
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.vehicle = vehicle;
        this.status = status;
        this.lastUpdate = update;
        this.worked = worked;
    }

    @Override
    public void apply(Driver entity) {
        city = new CityDTO(entity.getCity());
        vehicle = entity.getVehicle() == null ? null : new VehicleDTO(entity.getVehicle());
        order = entity.getOrder() == null ? null : new OrderDTO(entity.getOrder());
        user = new UserDTO(entity.getUser());
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Driver.Status getStatus() {
        return status;
    }

    public void setStatus(Driver.Status status) {
        this.status = status;
    }

    public Timestamp getUpdate() {
        return lastUpdate;
    }

    public void setUpdate(Timestamp update) {
        this.lastUpdate = update;
    }

    public long getWorked() {
        return worked;
    }

    public void setWorked(int worked) {
        this.worked = worked;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverDTO driver = (DriverDTO) o;
        return id == driver.id &&
                Objects.equals(number, driver.number) &&
                Objects.equals(firstName, driver.firstName) &&
                Objects.equals(lastName, driver.lastName) &&
                Objects.equals(lastUpdate, driver.lastUpdate) &&
                worked == driver.worked &&
                status.equals(driver.status) &&
                (city.equals(driver.city) ||
                        (city == null && driver.city == null)) &&
                (vehicle.equals(driver.vehicle) ||
                        (vehicle == null && driver.vehicle == null)) &&
                (order.equals(driver.order) ||
                        (order == null && driver.order == null)) &&
                (user.equals(driver.user) ||
                        (user == null && driver.user == null));
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, number, firstName, lastName, status,
                lastUpdate, worked, city, vehicle, order, user);
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", last update=" + lastUpdate +
                ", worked=" + worked +
                ", city=" + city +
                ", vehicle=" + vehicle +
                ", order=" + order +
                ", user=" + user +
                '}';
    }

}
