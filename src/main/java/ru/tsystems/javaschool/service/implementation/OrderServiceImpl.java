package ru.tsystems.javaschool.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.CargoDAO;
import ru.tsystems.javaschool.dao.CityDAO;
import ru.tsystems.javaschool.dao.OrderDAO;
import ru.tsystems.javaschool.dto.CheckpointDTO;
import ru.tsystems.javaschool.dto.OrderDTO;
import ru.tsystems.javaschool.dto.SubtaskDTO;
import ru.tsystems.javaschool.entity.Cargo;
import ru.tsystems.javaschool.entity.Checkpoint;
import ru.tsystems.javaschool.entity.Order;
import ru.tsystems.javaschool.entity.Subtask;
import ru.tsystems.javaschool.service.CityService;
import ru.tsystems.javaschool.service.OrderService;
import ru.tsystems.javaschool.service.VehicleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    private OrderDAO orderDAO;
    private CityDAO cityDAO;
    private CargoDAO cargoDAO;
    private CityService cityService;
    private VehicleService vehicleService;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO, CityService cityService,
                            VehicleService vehicleService, CityDAO cityDAO,
                            CargoDAO cargoDAO) {

        this.orderDAO = orderDAO;
        this.cityDAO = cityDAO;
        this.cargoDAO = cargoDAO;
        this.cityService = cityService;
        this.vehicleService = vehicleService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OrderDTO> getAll() {
        return orderDAO.getAll().stream()
                .map(x -> {
                    OrderDTO orderDTO = new OrderDTO(x);
                    orderDTO.apply(x);
                    return orderDTO;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public OrderDTO getById(int id) {
        Order order = orderDAO.getById(id);
        OrderDTO orderDTO = new OrderDTO(order);
        orderDTO.apply(order);
        return orderDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public OrderDTO getByNumber(int number) {
        Order order = orderDAO.getByNumber(number);
        OrderDTO orderDTO = new OrderDTO(order);
        orderDTO.apply(order);
        return orderDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(OrderDTO orderDTO) { //add check load and unload
        Order order = new Order();

        order.setNumber(order.getNumber());

        List<CheckpointDTO> checkpoints = orderDTO.getCheckpoints();

        for (CheckpointDTO checkpointDTO : checkpoints) {
            Checkpoint checkpoint = new Checkpoint();

            checkpoint.setOrder(order);
            order.putCheckpoint(checkpoint);

            String nameOfCity = checkpoint.getCity().getName();

            checkpoint.setCity(cityDAO.getByName(nameOfCity));

            List<SubtaskDTO> subtasks = checkpointDTO.getTasks();
            for (SubtaskDTO subtaskDTO : subtasks) {
                Subtask subtask = new Subtask();

                subtask.setCheckpoint(checkpoint);
                checkpoint.putSubtask(subtask);

                subtask.setOperation(subtaskDTO.getOperation());

                int numberCargo = subtaskDTO.getCargo().getNumber();
                Cargo cargo = cargoDAO.getByNumber(numberCargo);
                subtask.setCargo(cargo);
            }
        }
        orderDAO.insert(order);
        return order.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public int needCapacity(int number) {
        Order order = orderDAO.getByNumber(number);

        int maxWeight = 0;

        for (Checkpoint checkpoint : order.getCheckpoints()) {
            int weightForOneSubtask = 0;

            for (Subtask subtask : checkpoint.getTasks()) {
                Cargo cargo = subtask.getCargo();

                if (subtask.getOperation() == Subtask.Operation.LOADING) {
                    weightForOneSubtask += cargo.getWeight();
                }
            }
            if (weightForOneSubtask > maxWeight) {
                maxWeight = weightForOneSubtask;
            }
        }
        return maxWeight + 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public int spendTime(int number) {
        double length = 0;

        Order order = orderDAO.getByNumber(number);

        List<Checkpoint> checkpoints = order.getCheckpoints();
        String prevNameOfCity = checkpoints.get(0).getCity().getName();

        for (Checkpoint checkpoint : checkpoints) {
            String currentNameOfCity = checkpoint.getCity().getName();
            length += cityService.distance(prevNameOfCity, currentNameOfCity);
            prevNameOfCity = currentNameOfCity;
        }

        return (int) (length / vehicleService.speed() + 1); // hours
    }
}
