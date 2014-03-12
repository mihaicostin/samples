package com.mc.spring.samples.console.persistence.dao;

import com.mc.spring.samples.console.persistence.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * This DAO is just an interface extending the provided spring-data repository.
 * </br>
 * New methods will need to respect the conventions defined by spring-data:
 * http://docs.spring.io/spring-data/jpa/docs/current/reference/html/jpa.repositories.html
 * in order to be transformed into valid queries.
 *
 * It's marked with @Repository for the exception handling - see PersistenceExceptionTranslationPostProcessor.
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User findByUserName(String username);

}
