package ru.tsystems.javaschool.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.*;
import ru.tsystems.javaschool.dto.DriverDTO;
import ru.tsystems.javaschool.entity.*;
import ru.tsystems.javaschool.service.DriverService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {
    private DriverDAO driverDAO;
    private CityDAO cityDAO;
    private UserDAO userDAO;
    private VehicleDAO vehicleDAO;
    private OrderDAO orderDAO;

    @Autowired
    public DriverServiceImpl(DriverDAO driverDAO, CityDAO cityDAO,
                             UserDAO userDAO, VehicleDAO vehicleDAO,
                             OrderDAO orderDAO) {
        this.driverDAO = driverDAO;
        this.cityDAO = cityDAO;
        this.userDAO = userDAO;
        this.vehicleDAO = vehicleDAO;
        this.orderDAO = orderDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<DriverDTO> getAll() {
        return driverDAO.getAll().stream()
                .map(x -> {
                    DriverDTO driverDTO = new DriverDTO(x);
                    driverDTO.apply(x);
                    return driverDTO;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public DriverDTO getById(int id) {
        Driver driver = driverDAO.getById(id);
        DriverDTO driverDTO = new DriverDTO(driver);
        driverDTO.apply(driver);
        return driverDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public DriverDTO getByNumber(String number) {
        Driver driver = driverDAO.getByNumber(number);
        DriverDTO driverDTO = new DriverDTO(driver);
        driverDTO.apply(driver);
        return driverDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(DriverDTO driverDTO) {
        Driver driver = new Driver();

        driver.setNumber(driverDTO.getNumber());
        driver.setFirstName(driverDTO.getFirstName());
        driver.setLastName(driverDTO.getLastName());

        String nameCity = driverDTO.getCity().getName();
        City city = cityDAO.getByName(nameCity);

        driver.setCity(city);
        city.putDriver(driver);

        String loginUser = driverDTO.getUser().getLogin();
        User user = userDAO.getByLogin(loginUser);

        driver.setUser(user);

        driverDAO.insert(driver);
        return driver.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DriverDTO driverDTO) {
        String numberDriver = driverDTO.getNumber();
        Driver driver = driverDAO.getByNumber(numberDriver);

        driver.setFirstName(driverDTO.getFirstName());
        driver.setLastName(driverDTO.getLastName());

        String nameCity = driverDTO.getCity().getName();
        City city = cityDAO.getByName(nameCity);
        driverDAO.move(driver, city);

        driver.setStatus(driverDTO.getStatus()); //necessary to recount worked

        String numberVehicle = driverDTO.getVehicle().getNumber();
        Vehicle vehicle = vehicleDAO.getByNumber(numberVehicle);
        driverDAO.setVehicle(driver, vehicle);

        int numberOrder = driverDTO.getOrder().getNumber();
        Order order = orderDAO.getByNumber(numberOrder); //What is if order isn't?
        driver.setOrder(order);

        driverDAO.update(driver);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeByNumber(String number) {
        Driver removeDriver = driverDAO.getByNumber(number);
        String removeUserByLogin = removeDriver.getUser().getLogin();

        removeDriver.getCity().removeDriver(removeDriver);  //delete also from city's list
        removeDriver.getVehicle().removeDriver(removeDriver);

        int answer = removeDriver.getId();

        driverDAO.deleteByNumber(number);
        userDAO.deleteByLogin(removeUserByLogin);

        return answer;
    }
}
