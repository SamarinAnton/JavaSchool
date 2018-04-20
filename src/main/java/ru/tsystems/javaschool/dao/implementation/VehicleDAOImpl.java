package ru.tsystems.javaschool.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.VehicleDAO;
import ru.tsystems.javaschool.entity.City;
import ru.tsystems.javaschool.entity.Vehicle;

@Repository
public class VehicleDAOImpl extends AbstractDAOImpl<Vehicle> implements VehicleDAO{

    public VehicleDAOImpl() {
        super(Vehicle.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public Vehicle getByNumber(String number) {
        return (Vehicle) sessionFactory.getCurrentSession()
                .createQuery("from Vehicle x where x.number = :val")
                .setParameter("val", number)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public int deleteByNumber(String number) {
        Vehicle vehicle = getByNumber(number);
        vehicle.getCity().removeVehicle(vehicle);
        return sessionFactory.getCurrentSession()
                .createQuery("delete from Vehicle x where x.number = :val")
                .setParameter("val", number)
                .executeUpdate();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void move(Vehicle vehicle, City city) {
        City prevCity = vehicle.getCity();
        vehicle.setCity(city);

        prevCity.removeVehicle(vehicle);
        city.putVehicle(vehicle);
    }
}
