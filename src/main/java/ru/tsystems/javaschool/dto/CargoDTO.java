package ru.tsystems.javaschool.dto;

import ru.tsystems.javaschool.entity.Cargo;
import ru.tsystems.javaschool.entity.Vehicle;

import java.util.Objects;

public class CargoDTO extends AbstractDTO<Cargo> {

    private int number;
    private String name;
    private double weight;
    private Cargo.Status status;
    private CityDTO city;
    private VehicleDTO vehicle;

    public CargoDTO() {
    }

    public CargoDTO(int id, int number, double weight, Cargo.Status status, CityDTO city,
                    VehicleDTO vehicle, String name) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.city = city;
        this.status = status;
        this.vehicle = vehicle;
        this.number = number;
    }

    public CargoDTO(String name, double weight, CityDTO city) {
        this.name = name;
        this.weight = weight;
        this.city = city;
    }

    public CargoDTO(Cargo entity) {
        this.id = entity.getId();
        this.number = entity.getNumber();
        this.weight = entity.getWeight();
        this.city = null;
        this.status = entity.getStatus();
        this.vehicle = null;
        this.name = entity.getName();
    }

    @Override
    public void apply(Cargo entity) {
        this.city = new CityDTO(entity.getCity());

        Vehicle entityVehicle = entity.getVehicle();
        this.vehicle = entityVehicle == null ? null : new VehicleDTO(entity.getVehicle());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Cargo.Status getStatus() {
        return status;
    }

    public void setStatus(Cargo.Status status) {
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoDTO cargo = (CargoDTO) o;
        return id == cargo.id &&
                number == cargo.number &&
                Objects.equals(name, cargo.name) &&
                weight == cargo.weight &&
                status.equals(cargo.status) &&
                (vehicle.equals(cargo.vehicle) ||
                    (vehicle == null && cargo.vehicle == null)) &&
                (city.equals(cargo.city) ||
                        (city == null && cargo.city == null));
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, number, name, weight, status, vehicle, city);
    }

    @Override
    public String toString() {
        return "CargoDTO{" +
                "id=" + id +
                "number=" + number +
                ", name='" + name + '\'' +
                ", weightKg=" + weight +
                ", city=" + city +
                ", status=" + status +
                ", vehicle=" + vehicle +
                '}';
    }
}
