package ru.tsystems.javaschool.dto;

import ru.tsystems.javaschool.entity.Checkpoint;
import ru.tsystems.javaschool.entity.Order;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderDTO extends AbstractDTO<Order> {

    private int number;
    private Order.Done done;
    private VehicleDTO vehicle;

    private List<CheckpointDTO> checkpoints;

    public OrderDTO() {
    }

    public OrderDTO(int id, int number, Order.Done done,
                    VehicleDTO vehicle, List<CheckpointDTO> checkpoints) {
        this.id = id;
        this.number = number;
        this.done = done;
        this.vehicle = vehicle;
        this.checkpoints = checkpoints;
    }

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.number = entity.getNumber();
        this.done = entity.getStatus();
        this.vehicle = null;
        this.checkpoints = null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void apply(Order entity) {
        List<Checkpoint> entityCheckpoints = entity.getCheckpoints();
        if (entityCheckpoints == null) {
            this.checkpoints = Collections.emptyList();
        } else {
            this.checkpoints = entityCheckpoints.stream().map(x -> {
                CheckpointDTO res = new CheckpointDTO(x);
                res.apply(x);
                return res;
            }).collect(Collectors.toList());
        }

        vehicle = entity.getVehicle() == null ? null : new VehicleDTO(entity.getVehicle());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Order.Done getStatus() {
        return done;
    }

    public void setStatus(Order.Done done) {
        this.done = done;
    }

    public List<CheckpointDTO> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<CheckpointDTO> checkpoints) {
        this.checkpoints = checkpoints;
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
        OrderDTO order = (OrderDTO) o;
        return id == order.id &&
                number == order.number &&
                done.equals(order.done) &&
                (checkpoints.equals(order.checkpoints) ||
                        (checkpoints == null && order.checkpoints == null)) &&
                (vehicle.equals(order.vehicle) ||
                        (vehicle == null && order.vehicle == null));
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, number, done, checkpoints, vehicle);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                "number=" + number +
                "done=" + done +
                ", checkpoints=" + checkpoints +
                ", vehicle=" + vehicle +
                '}';
    }
}
