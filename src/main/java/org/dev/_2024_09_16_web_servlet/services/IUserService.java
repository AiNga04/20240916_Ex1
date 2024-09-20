package org.dev._2024_09_16_web_servlet.services;

import org.dev._2024_09_16_web_servlet.models.Usermodel;

public interface IUserService {
    Usermodel login(String username, String password);
    Usermodel FindByUsername(String username);
    void insertUser(Usermodel user);
    boolean register(String email, String password, String username, String
            fullname, String phone);
    boolean checkExistEmail(String email);
    boolean checkExistPhone(String phone);
    boolean checkExistUsername(String username);
}
