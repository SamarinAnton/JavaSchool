package ru.tsystems.javaschool.dao.implementation;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.UserDAO;
import ru.tsystems.javaschool.entity.User;

@Repository
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public User getByLogin(String login) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User user where user.login = ?1")
                .setParameter(1, login)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public int deleteByLogin(String login) {
        return sessionFactory.getCurrentSession()
                .createQuery("delete from User x where x.login = :val")
                .setParameter("val", login)
                .executeUpdate();
    }
}
