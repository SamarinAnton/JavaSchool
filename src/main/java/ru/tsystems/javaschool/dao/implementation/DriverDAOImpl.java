package ru.tsystems.javaschool.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.DriverDAO;
import ru.tsystems.javaschool.entity.Driver;

@Repository
public class DriverDAOImpl extends AbstractDAOImpl<Driver> implements DriverDAO {

    public DriverDAOImpl() {
        super(Driver.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public Driver getByNumber(String number) {
        return (Driver) sessionFactory.getCurrentSession()
                .createQuery("from Driver x where x.number = :val")
                .setParameter("val", number)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public int deleteByNumber(String number) {
        return sessionFactory.getCurrentSession()
                .createQuery("delete from Driver x where x.number = :val")
                .setParameter("val", number)
                .executeUpdate();
    }
}
