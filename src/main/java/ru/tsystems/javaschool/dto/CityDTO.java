package ru.tsystems.javaschool.dto;

import ru.tsystems.javaschool.entity.City;
import ru.tsystems.javaschool.entity.Driver;
import ru.tsystems.javaschool.entity.Vehicle;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CityDTO extends AbstractDTO<City> {

    private String name;
    private double latitude;
    private double longitude;

    private List<DriverDTO> drivers;
    private List<VehicleDTO> vehicles;

    public CityDTO() {
    }

    public CityDTO(String name) {
        this.name = name;
    }

    public CityDTO(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public CityDTO(String name, double latitude, double longitude, int id,
                   List<DriverDTO> drivers, List<VehicleDTO> vehicles) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.drivers = drivers;
        this.vehicles = vehicles;
    }

    public CityDTO(City entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
        this.drivers = null;
        this.vehicles = null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void apply(City entity) {
        List<Driver> entityDrivers = entity.getDrivers();
        if (entityDrivers == null) {
            this.drivers = Collections.emptyList();
        } else {
            this.drivers = entityDrivers.stream().map(DriverDTO::new).collect(Collectors.toList());
        }

        List<Vehicle> entityVehicles = entity.getVehicles();
        if (entityVehicles == null) {
            this.vehicles = Collections.emptyList();
        } else {
            this.vehicles = entityVehicles.stream().map(VehicleDTO::new).collect(Collectors.toList());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<DriverDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverDTO> drivers) {
        this.drivers = drivers;
    }

    public List<VehicleDTO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDTO> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDTO city = (CityDTO) o;
        return id == city.id &&
                Objects.equals(name, city.name) &&
                latitude == city.latitude &&
                longitude == city.longitude &&
                (drivers.equals(city.drivers) ||
                        (drivers == null && city.drivers == null)) &&
                (vehicles.equals(city.vehicles) ||
                        (vehicles == null && city.vehicles == null));
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, latitude, longitude, drivers, vehicles);
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", drivers=" + drivers +
                ", vehicles=" + vehicles +
                '}';
    }

}
