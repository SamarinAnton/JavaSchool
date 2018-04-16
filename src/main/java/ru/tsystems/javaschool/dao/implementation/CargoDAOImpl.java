package ru.tsystems.javaschool.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.tsystems.javaschool.dao.CargoDAO;
import ru.tsystems.javaschool.entity.Cargo;

@Repository
public class CargoDAOImpl extends AbstractDAOImpl<Cargo> implements CargoDAO{

    public CargoDAOImpl() {
        super(Cargo.class);
    }

    public int deleteByNumber(int number) {
        return sessionFactory.getCurrentSession()
                .createQuery("delete from Cargo x where x.number = :val")
                .setParameter("val", number)
                .executeUpdate();
    }
}
