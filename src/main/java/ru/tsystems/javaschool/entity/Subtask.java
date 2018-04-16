package ru.tsystems.javaschool.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subtasks", schema = "trucking")
public class Subtask {

    public enum Operation {LOADING, UNLOADING}

    private int id;
    private Checkpoint checkpoint;
    private Cargo cargo;
    private Operation operation;

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
    @Column(name = "operation", nullable = false)
    @Enumerated(EnumType.STRING)
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @ManyToOne
    @JoinColumn(name = "checkpoint_id", referencedColumnName = "id", nullable = false)
    public Checkpoint getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(Checkpoint checkpoint) {
        this.checkpoint = checkpoint;
    }

    @ManyToOne
    @JoinColumn(name = "cargo_id", referencedColumnName = "id", nullable = false)
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subtask subtask = (Subtask) o;
        return id == subtask.id &&
                operation.equals(subtask.operation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, operation);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                "operation=" + operation +
                '}';
    }
}
