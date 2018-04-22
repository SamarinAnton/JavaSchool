package ru.tsystems.javaschool.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "trucking")
public class Order {

    public enum Done {YES, NO}

    private int id;
    private int number;
    private Done done = Done.NO;
    private Vehicle vehicle;

    private List<Checkpoint> checkpoints;

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
    @Column(name = "done_order", nullable = false)
    @Enumerated(EnumType.STRING)
    public Done getStatus() {
        return done;
    }

    public void setStatus(Done done) {
        this.done = done;
    }

    @OneToOne
    @JoinColumn(name = "vehicles_id", referencedColumnName = "id")
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST})
    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public void putCheckpoint(Checkpoint checkpoint) {
        if (checkpoints == null) {
            checkpoints = new LinkedList<>();
        }
        checkpoints.add(checkpoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                number == order.number &&
                done.equals(order.done);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, number, done);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number=" + number +
                ", done=" + done +
                '}';
    }
}
