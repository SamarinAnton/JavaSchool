package ru.tsystems.javaschool.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cities", schema = "trucking")
public class City {

    private int id;
    private String name;
    private double latitude;
    private double longitude;

    private List<Driver> drivers;
    private List<Vehicle> vehicles;

    public City() {
    }

    public City(int id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
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
    @Column(name = "name", nullable = false, length = 45, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "latitude", nullable = false, precision = 2)
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = false, precision = 2)
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @OneToMany(mappedBy = "city")
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

    public boolean removeDriver(Driver driver) {
        return drivers.remove(driver);
    }

    @OneToMany(mappedBy = "city")
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void putVehicle(Vehicle vehicle) {
        if (vehicles == null) {
            vehicles = new LinkedList<>();
        }
        vehicles.add(vehicle);
    }

    public boolean removeVehicle(Vehicle vehicle) {
        return vehicles.remove(vehicle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id &&
                Objects.equals(name, city.name) &&
                latitude == city.latitude &&
                longitude == city.longitude;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, latitude, longitude);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
