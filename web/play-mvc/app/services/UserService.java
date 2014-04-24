package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.persistence.dao.UserDao;
import services.persistence.model.User;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Transactional
    public List<User> getUsers() {
        return userDao.getAll();
    }


}
