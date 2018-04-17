package ru.tsystems.javaschool.dao.implementation;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.CargoDAO;
import ru.tsystems.javaschool.entity.Cargo;
import ru.tsystems.javaschool.entity.City;

@Repository
public class CargoDAOImpl extends AbstractDAOImpl<Cargo> implements CargoDAO{

    public CargoDAOImpl() {
        super(Cargo.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public Cargo getByNumber(int number) {
        Session session = sessionFactory.getCurrentSession();
        return (Cargo) session
                .createQuery("from Cargo cargo where cargo.number = :val")
                .setParameter("val", number)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public int deleteByNumber(int number) {
        return sessionFactory.getCurrentSession()
                .createQuery("delete from Cargo x where x.number = :val")
                .setParameter("val", number)
                .executeUpdate();
    }
}
