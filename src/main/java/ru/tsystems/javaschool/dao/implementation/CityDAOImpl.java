package ru.tsystems.javaschool.dao.implementation;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.CityDAO;
import ru.tsystems.javaschool.entity.City;

@Repository
public class CityDAOImpl extends AbstractDAOImpl<City> implements CityDAO{

    public CityDAOImpl() {
        super(City.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public City getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return (City) session
                .createQuery("from City city where city.name = :val")
                .setParameter("val", name)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public int deleteByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("delete from City x where x.name = :val")
                .setParameter("val", name)
                .executeUpdate();
    }
}
