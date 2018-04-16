package ru.tsystems.javaschool.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cargoes", schema = "trucking")
public class Cargo {

    public enum Status {READY, SHIPPED, DELIVERED}

    private int id;
    private int number;
    private String name;
    private double weight;
    private Status status = Status.READY;
    private City city;
    private Vehicle vehicle;

    public Cargo() {
    }

    public Cargo(int id, String name, double weight, Status status, int number) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.status = status;
        this.number = number;
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
    @Column(name = "number", nullable = false, unique = true)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "weight", nullable = false, precision = 3)
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return id == cargo.id &&
                number == cargo.number &&
                Objects.equals(name, cargo.name) &&
                weight == cargo.weight &&
                status.equals(cargo.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, number, name, weight, status);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", status=" + status +
                ", number=" + number +
                '}';
    }
}
