package ru.tsystems.javaschool.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vehicles", schema = "trucking")
public class Vehicle {

    public enum Status {OK, BROKEN}

    private int id;
    private String number;
    private int capacity;
    private int count;
    private City city;
    private Order order;
    private Status status = Status.OK;

    private List<Driver> drivers;
    private List<Cargo> cargoes;

    public Vehicle() {
    }

    public Vehicle(int id, String number, int capacity, Status status, City city, int count) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.status = status;
        this.city = city;
        this.count = count;
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
    @Column(name = "number", nullable = false, length = 45, unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "capacity", nullable = false)
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "count_drivers", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    @ManyToOne
    @JoinColumn(name = "cities_id", referencedColumnName = "id", nullable = false)
    public City getCity() {
        return city;
    }

    public void setCity(City citiesByCityId) {
        this.city = citiesByCityId;
    }

    @OneToMany(mappedBy = "vehicle")
    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public void putDriver(Driver driver) {
        if (drivers == null) {
            drivers = new LinkedList<>();
        }
        drivers.add(driver);
    }

    @SuppressWarnings("UnusedReturnValue")
    public boolean removeDriver(Driver driver) {
        return drivers.remove(driver);
    }

    @OneToMany(mappedBy = "vehicle")
    public List<Cargo> getCargoes() {
        return cargoes;
    }

    public void setCargoes(List<Cargo> cargoes) {
        this.cargoes = cargoes;
    }

    public void putCargo(Cargo cargo) {
        if (cargoes == null) {
            cargoes = new LinkedList<>();
        }
        cargoes.add(cargo);
    }

    @SuppressWarnings("UnusedReturnValue")
    public boolean removeCargo(Cargo cargo) {
        return cargoes.remove(cargo);
    }

    @OneToOne(mappedBy = "vehicle")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id &&
                capacity == vehicle.capacity &&
                count == vehicle.count &&
                Objects.equals(number, vehicle.number) &&
                status.equals(vehicle.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, number, capacity, count, status);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
                ", count=" + count +
                ", status=" + status +
                '}';
    }

}
