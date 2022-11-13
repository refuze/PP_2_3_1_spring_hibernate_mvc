package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User get(Long id) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where id = :id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<User> getList() {
        return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }
}
