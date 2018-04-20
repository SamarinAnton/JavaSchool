package ru.tsystems.javaschool.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.OrderDAO;
import ru.tsystems.javaschool.entity.Order;
import ru.tsystems.javaschool.entity.Vehicle;

@Repository
public class OrderDAOImpl extends AbstractDAOImpl<Order> implements OrderDAO {

    public OrderDAOImpl() {
        super(Order.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public Order getByNumber(int number) {
        return (Order) sessionFactory.getCurrentSession()
                .createQuery("from Order x where x.number = :val")
                .setParameter("val", number)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public int deleteByNumber(int number) {
        return sessionFactory.getCurrentSession()
                .createQuery("delete from Order x where x.number = :val")
                .setParameter("val", number)
                .executeUpdate();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void setVehicle(Order order, Vehicle vehicle) {
        order.setVehicle(vehicle);
        vehicle.setOrder(order);
    }
}
