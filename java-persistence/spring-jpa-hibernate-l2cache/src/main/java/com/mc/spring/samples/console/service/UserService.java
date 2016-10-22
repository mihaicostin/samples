package com.mc.spring.samples.console.service;

import com.mc.spring.samples.console.persistence.dao.UserDao;
import com.mc.spring.samples.console.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Transactional
    public List<User> getUsers() {
        return userDao.getAll();
    }


}