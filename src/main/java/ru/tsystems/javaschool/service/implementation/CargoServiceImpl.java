package ru.tsystems.javaschool.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.CargoDAO;
import ru.tsystems.javaschool.dao.CityDAO;
import ru.tsystems.javaschool.dto.CargoDTO;
import ru.tsystems.javaschool.entity.Cargo;
import ru.tsystems.javaschool.entity.City;
import ru.tsystems.javaschool.service.CargoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoServiceImpl implements CargoService{
    private CityDAO cityDAO;
    private CargoDAO cargoDAO;

    @Autowired
    public CargoServiceImpl(CargoDAO cargoDAO, CityDAO cityDAO) {
        this.cargoDAO = cargoDAO;
        this.cityDAO = cityDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<CargoDTO> getAll() {
        return cargoDAO.getAll().stream()
                .map(x -> {
                    CargoDTO cargoDTO = new CargoDTO(x);
                    cargoDTO.apply(x);
                    return cargoDTO;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public CargoDTO getById(int id) {
        Cargo cargo = cargoDAO.getById(id);
        CargoDTO cargoDTO = new CargoDTO(cargo);
        cargoDTO.apply(cargo);
        return cargoDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public int add(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo();

        cargo.setName(cargoDTO.getName());
        cargo.setNumber(cargoDTO.getNumber());
        cargo.setWeight(cargoDTO.getWeight());

        String cityCargo = cargoDTO.getCity().getName();
        City city = cityDAO.getByName(cityCargo);
        cargo.setCity(city);

        cargoDAO.insert(cargo);

        return cargo.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void update(CargoDTO cargoDTO) {
        int numberCargo = cargoDTO.getNumber();
        Cargo cargo = cargoDAO.getByNumber(numberCargo);

        cargo.setName(cargoDTO.getName());
        cargo.setWeight(cargoDTO.getWeight());

        cargoDAO.update(cargo);
    }
}
