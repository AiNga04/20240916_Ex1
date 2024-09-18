package org.dev._2024_09_16_web_servlet.services.implement;

import org.dev._2024_09_16_web_servlet.dao.Implement.UserDaoImplement;
import org.dev._2024_09_16_web_servlet.models.Usermodel;
import org.dev._2024_09_16_web_servlet.services.IUserService;

public class UserServiceImplement implements IUserService {
    UserDaoImplement userDao = new UserDaoImplement();

    @Override
    public Usermodel login(String username, String password) {
        Usermodel user = new Usermodel();
        if (user != null && password.equals(user.getPassword())) {
            user.setUsername(username);
            user.setPassword(null);
            return user;
        }
        return null;
    }

    @Override
    public Usermodel get(String username) {
        return userDao.get(username);
    }
}
