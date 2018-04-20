package ru.tsystems.javaschool.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.CityDAO;
import ru.tsystems.javaschool.dto.CityDTO;
import ru.tsystems.javaschool.entity.City;
import ru.tsystems.javaschool.service.CityService;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.*;

@Service
public class CityServiceImpl implements CityService {
    private static final double RADIUS = 6371.0;
    private static final double ERROR = 1.15;

    private CityDAO cityDAO;

    @Autowired
    public CityServiceImpl(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<CityDTO> getAll() {
        return cityDAO.getAll().stream()
                .map(x -> {
                    CityDTO cityDTO = new CityDTO(x);
                    cityDTO.apply(x);
                    return cityDTO;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public CityDTO getById(int id) {
        City city = cityDAO.getById(id);
        CityDTO cityDTO = new CityDTO(city);
        cityDTO.apply(city);
        return cityDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public CityDTO getByName(String name) {
        City city = cityDAO.getByName(name);
        CityDTO cityDTO = new CityDTO(city);
        cityDTO.apply(city);
        return cityDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(CityDTO cityDTO) {
        City city = new City();

        city.setName(cityDTO.getName());
        city.setLatitude(cityDTO.getLatitude());
        city.setLongitude(cityDTO.getLongitude());
        cityDAO.insert(city);
        return city.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public double distance(String name1, String name2) {
        City city1 = cityDAO.getByName(name1);
        City city2 = cityDAO.getByName(name2);
        return RADIUS * ERROR * acos(sin(toRadians(city1.getLatitude())) *
            sin(toRadians(city2.getLatitude())) + cos(toRadians(city1.getLatitude())) *
            cos(toRadians(city2.getLatitude())) * cos(toRadians(city1.getLongitude() -
            city2.getLongitude())));
    }
}
