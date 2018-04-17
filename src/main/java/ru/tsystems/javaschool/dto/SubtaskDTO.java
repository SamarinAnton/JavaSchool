package ru.tsystems.javaschool.dto;

import ru.tsystems.javaschool.entity.Subtask;

import java.util.Objects;

public class SubtaskDTO extends AbstractDTO<Subtask> {

    private CheckpointDTO checkpoint;
    private CargoDTO cargo;
    private Subtask.Operation operation;

    public SubtaskDTO() {
    }

    public SubtaskDTO(int id, CheckpointDTO checkpoint, CargoDTO cargo,
                      Subtask.Operation operation) {
        this.id = id;
        this.checkpoint = checkpoint;
        this.cargo = cargo;
        this.operation = operation;
    }

    public SubtaskDTO(Subtask entity) {
        this.id = entity.getId();
        this.operation = entity.getOperation();
        this.cargo = null;
        this.checkpoint = null;
    }

    @Override
    public void apply(Subtask entity) {
        cargo = new CargoDTO(entity.getCargo());
        checkpoint = new CheckpointDTO(entity.getCheckpoint());
    }

    public CheckpointDTO getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(CheckpointDTO checkpoint) {
        this.checkpoint = checkpoint;
    }

    public CargoDTO getCargo() {
        return cargo;
    }

    public void setCargo(CargoDTO cargo) {
        this.cargo = cargo;
    }

    public Subtask.Operation getOperation() {
        return operation;
    }

    public void setOperation(Subtask.Operation operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubtaskDTO subtask = (SubtaskDTO) o;
        return id == subtask.id &&
                operation.equals(subtask.operation) &&
                (checkpoint.equals(subtask.checkpoint) ||
                        (checkpoint == null && subtask.checkpoint == null)) &&
                (cargo.equals(subtask.cargo) ||
                        (cargo == null && subtask.cargo == null));
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, operation, checkpoint, cargo);
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                "operation=" + operation +
                ", checkpoint=" + checkpoint +
                ", cargo=" + cargo +
                '}';
    }
}
