package ru.tsystems.javaschool.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.AbstractDAO;

import java.util.List;


public abstract class AbstractDAOImpl<E> implements AbstractDAO<E>{

    private Class<E> entityClass;
    protected SessionFactory sessionFactory;

    protected AbstractDAOImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<E> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from " + entityClass.getSimpleName()).list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public E getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(entityClass, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void insert(E entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void update(E entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public int deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("delete from " + entityClass.getSimpleName() + " x where x." + "id" + " = :val")
                .setParameter("val", id)
                .executeUpdate();
    }
}
