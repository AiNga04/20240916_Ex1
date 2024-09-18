package org.dev._2024_09_16_web_servlet.dao;

import org.dev._2024_09_16_web_servlet.models.Usermodel;

import java.util.List;

public interface IUserDao {
    List<Usermodel> getUsers();
    Usermodel findByUsername(String username);
    Usermodel get(String username);
    Usermodel findById(int id);
    Usermodel findByEmail(String email);
    List<Usermodel> findByRoleId(int roleId);

//    Usermodel save(Usermodel usermodel);
//    Usermodel update(Usermodel usermodel);
//    Usermodel delete(int id);
//    Usermodel login(String username, String password);
//    Usermodel changePassword(String username, String oldPassword, String newPassword);
//    Usermodel changeEmail(String username, String email);
//    Usermodel changePassword(String oldPassword, String newPassword);
//    Usermodel changeEmail(String email);
//    Usermodel changePassword(String oldPassword);
    void insert(Usermodel user);
}
