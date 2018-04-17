package ru.tsystems.javaschool.dto;

import ru.tsystems.javaschool.entity.Cargo;

import ru.tsystems.javaschool.entity.Driver;
import ru.tsystems.javaschool.entity.Vehicle;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VehicleDTO extends AbstractDTO<Vehicle> {

    private String number;
    private int capacity;
    private int count;
    private CityDTO city;
    private OrderDTO order;
    private Vehicle.Status status;

    private List<DriverDTO> drivers;
    private List<CargoDTO> cargoes;

    public VehicleDTO() {
    }

    public VehicleDTO(int id, String number, int capacity, Vehicle.Status status,
                      CityDTO city, OrderDTO order, List<DriverDTO> drivers,
                      List<CargoDTO> cargoes, int count) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.status = status;
        this.city = city;
        this.order = order;
        this.drivers = drivers;
        this.cargoes = cargoes;
        this.count = count;
    }

    public VehicleDTO(Vehicle entity) {
        this.id = entity.getId();
        this.capacity = entity.getCapacity();
        this.number = entity.getNumber();
        this.count = entity.getCount();
        this.status = entity.getStatus();
        this.city = null;
        this.order = null;
        this.drivers = null;
        this.cargoes = null;
    }

    @Override
    public void apply(Vehicle entity) {
        List<Driver> entityDrivers = entity.getDrivers();
        if (entityDrivers == null) {
            drivers = Collections.emptyList();
        } else {
            drivers = entityDrivers.stream().map(DriverDTO::new).collect(Collectors.toList());
        }

        List<Cargo> entityCargoes = entity.getCargoes();
        if (entityCargoes == null) {
            cargoes = Collections.emptyList();
        } else {
            cargoes = entityCargoes.stream().map(CargoDTO::new).collect(Collectors.toList());
        }

        order = entity.getOrder() == null ? null : new OrderDTO(entity.getOrder());
        city = new CityDTO(entity.getCity());
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Vehicle.Status getStatus() {
        return status;
    }

    public void setStatus(Vehicle.Status status) {
        this.status = status;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public List<DriverDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverDTO> drivers) {
        this.drivers = drivers;
    }

    public List<CargoDTO> getCargoes() {
        return cargoes;
    }

    public void setCargoes(List<CargoDTO> cargoes) {
        this.cargoes = cargoes;
    }


    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleDTO vehicle = (VehicleDTO) o;
        return id == vehicle.id &&
                capacity == vehicle.capacity &&
                count == vehicle.count &&
                Objects.equals(number, vehicle.number) &&
                status.equals(vehicle.status) &&
                (city.equals(vehicle.city) ||
                        (city == null && vehicle.city == null)) &&
                (order.equals(vehicle.order) ||
                        (order == null && vehicle.order == null)) &&
                (drivers.equals(vehicle.drivers) ||
                        (drivers == null && vehicle.drivers == null)) &&
                (cargoes.equals(vehicle.cargoes) ||
                        (cargoes == null && vehicle.cargoes == null));
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, number, capacity, count, status, city, order,
                drivers, cargoes);
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
                ", count=" + count +
                ", status=" + status +
                ", city=" + city +
                ", order=" + order +
                ", drivers=" + drivers +
                ", cargoes=" + cargoes +
                '}';
    }


}
