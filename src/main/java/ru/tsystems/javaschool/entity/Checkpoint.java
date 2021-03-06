package ru.tsystems.javaschool.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "checkpoints", schema = "trucking")
public class Checkpoint {

    private int id;
    private Order order;
    private City city;

    private List<Subtask> subtasks;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id", nullable = false)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "cities_id", referencedColumnName = "id", nullable = false)
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @OneToMany(mappedBy = "checkpoint", cascade = {CascadeType.PERSIST})
    public List<Subtask> getTasks() {
        return subtasks;
    }

    public void setTasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public void putSubtask(Subtask subtask) {
        if (subtasks == null) {
            subtasks = new LinkedList<>();
        }
        subtasks.add(subtask);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkpoint that = (Checkpoint) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Checkpoint{" +
                "id=" + id +
                '}';
    }
}
