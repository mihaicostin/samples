package com.mc.spring.samples.console.persistence.dao;

import com.mc.spring.samples.console.persistence.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * This DAO is using the hibernate session directly.
 * It's marked with @Repository for the exception handling - see PersistenceExceptionTranslationPostProcessor.
 */
@Repository
public class UserDao {

    @PersistenceContext
    private javax.persistence.EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public List<User> getAll() {
        Query query = em.createQuery("from User user");
        return query.getResultList();
    }

}
