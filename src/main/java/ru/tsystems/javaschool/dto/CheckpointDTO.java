package ru.tsystems.javaschool.dto;

import ru.tsystems.javaschool.entity.Checkpoint;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CheckpointDTO extends AbstractDTO<Checkpoint> {

    private OrderDTO order;
    private CityDTO city;

    private List<SubtaskDTO> subtasks;

    public CheckpointDTO() {
    }

    public CheckpointDTO(int id, OrderDTO order, CityDTO city, List<SubtaskDTO> subtasks) {
        this.id = id;
        this.order = order;
        this.city = city;
        this.subtasks = subtasks;
    }

    public CheckpointDTO(Checkpoint entity) {
        this.id = entity.getId();
        order = null;
        city = null;
        subtasks = null;
    }

    @Override
    public void apply(Checkpoint entity) {
        city = new CityDTO(entity.getCity());
        order = new OrderDTO(entity.getOrder());
        this.subtasks = entity.getTasks().stream().map(x -> {
            SubtaskDTO res = new SubtaskDTO(x);
            res.apply(x);
            return res;
        }).collect(Collectors.toList());
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public List<SubtaskDTO> getTasks() {
        return subtasks;
    }

    public void setSubtasks(List<SubtaskDTO> subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckpointDTO checkpoint = (CheckpointDTO) o;
        return id == checkpoint.id &&
                (order.equals(checkpoint.order) ||
                        (order == null && checkpoint.order == null)) &&
                (city.equals(checkpoint.city) ||
                        (city == null && checkpoint.city == null)) &&
                (subtasks.equals(checkpoint.subtasks) ||
                        (subtasks == null && checkpoint.subtasks == null));
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, city, order, subtasks);
    }

    @Override
    public String toString() {
        return "CheckpointDTO{" +
                "id=" + id +
                ", order=" + order +
                ", city=" + city +
                ", tasks=" + subtasks +
                '}';
    }
}
