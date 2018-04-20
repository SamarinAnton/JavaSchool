package ru.tsystems.javaschool.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.CityDAO;
import ru.tsystems.javaschool.dao.DriverDAO;
import ru.tsystems.javaschool.dao.OrderDAO;
import ru.tsystems.javaschool.dao.VehicleDAO;
import ru.tsystems.javaschool.dto.VehicleDTO;
import ru.tsystems.javaschool.entity.*;
import ru.tsystems.javaschool.service.VehicleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
    private static final double SPEED = 60.0;

    private VehicleDAO vehicleDAO;
    private CityDAO cityDAO;
    private DriverDAO driverDAO;
    private OrderDAO orderDAO;

    @Autowired
    public VehicleServiceImpl(VehicleDAO vehicleDAO, CityDAO cityDAO,
                              DriverDAO driverDAO, OrderDAO orderDAO) {
        this.vehicleDAO = vehicleDAO;
        this.cityDAO = cityDAO;
        this.driverDAO = driverDAO;
        this.orderDAO = orderDAO;
    }


    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<VehicleDTO> getAll() {
        return vehicleDAO.getAll().stream()
                .map(x -> {
                    VehicleDTO vehicleDTO = new VehicleDTO(x);
                    vehicleDTO.apply(x);
                    return vehicleDTO;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public VehicleDTO getById(int id) {
        Vehicle vehicle = vehicleDAO.getById(id);
        VehicleDTO vehicleDTO = new VehicleDTO(vehicle);
        vehicleDTO.apply(vehicle);
        return vehicleDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public VehicleDTO getByNumber(String number) {
        Vehicle vehicle = vehicleDAO.getByNumber(number);
        VehicleDTO vehicleDTO = new VehicleDTO(vehicle);
        vehicleDTO.apply(vehicle);
        return vehicleDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();

        vehicle.setNumber(vehicleDTO.getNumber());
        vehicle.setCapacity(vehicleDTO.getCapacity());
        vehicle.setCount(vehicleDTO.getCount());

        String nameCity = vehicleDTO.getCity().getName();
        City city = cityDAO.getByName(nameCity);
        vehicle.setCity(city);

        vehicleDAO.insert(vehicle);

        return vehicle.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(VehicleDTO vehicleDTO) {
        String numberVehicle = vehicleDTO.getNumber();
        Vehicle vehicle = vehicleDAO.getByNumber(numberVehicle);

        vehicle.setCapacity(vehicleDTO.getCapacity());
        vehicle.setCount(vehicleDTO.getCount());
        Vehicle.Status status = vehicleDTO.getStatus();
        if (status == Vehicle.Status.BROKEN)
            throw new RuntimeException("Vehicle is broke!");    //fix
        vehicle.setStatus(status);

        String nameCity = vehicleDTO.getCity().getName();
        City city = cityDAO.getByName(nameCity);

        vehicleDAO.move(vehicle, city);
        for (Driver driver : vehicle.getDrivers()) {
            driverDAO.move(driver, city);
        }
        for (Cargo cargo : vehicle.getCargoes()) {
            cargo.setCity(city);
        }

        int numberOrder = vehicleDTO.getOrder().getNumber();
        Order order = orderDAO.getByNumber(numberOrder);
        orderDAO.setVehicle(order, vehicle);

        vehicleDAO.update(vehicle);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeByNumber(String number) {
        int id = vehicleDAO.getByNumber(number).getId();//check that list of cargo and
        vehicleDAO.deleteByNumber(number);//list of drivers + order equals null
        return id;
    }

    @Override
    public double speed() {
        return SPEED;
    }
}
