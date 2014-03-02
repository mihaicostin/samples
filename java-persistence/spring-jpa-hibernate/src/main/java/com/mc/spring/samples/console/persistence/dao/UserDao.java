package com.mc.spring.samples.console.persistence.dao;

import com.mc.spring.samples.console.persistence.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This DAO is using the hibernate session directly.
 * It's marked with @Repository for the exception handling - see PersistenceExceptionTranslationPostProcessor.
 */
@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public List<User> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User user")
                .list();
    }

}
