package services.persistence.dao;

import org.springframework.stereotype.Repository;
import services.persistence.model.User;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * This DAO makes use of JPA.
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
