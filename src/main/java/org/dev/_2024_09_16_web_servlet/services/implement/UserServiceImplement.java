package org.dev._2024_09_16_web_servlet.services.implement;

import org.dev._2024_09_16_web_servlet.configs.DBconnectionMySQL;
import org.dev._2024_09_16_web_servlet.dao.Implement.UserDaoImplement;
import org.dev._2024_09_16_web_servlet.models.Usermodel;
import org.dev._2024_09_16_web_servlet.services.IUserService;

public class UserServiceImplement implements IUserService {
    //    Lấy toàn bộ hàm trong tầng dao
    UserDaoImplement userDao = new UserDaoImplement();

    @Override
    public Usermodel login(String username, String password) {
        Usermodel user = this.FindByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public Usermodel FindByUsername(String username) {
        return userDao.findByUsername(username);
    }

    //    register
    @Override
    public void insertUser(Usermodel user) {

    }

    @Override
    public boolean register(String email, String password, String username, String fullname, String phone) {
        return false;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        return false;
    }
}
