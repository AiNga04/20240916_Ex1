package org.dev._2024_09_16_web_servlet.configs;

import org.dev._2024_09_16_web_servlet.dao.IUserDao;
import org.dev._2024_09_16_web_servlet.dao.Implement.UserDaoImplement;
import org.dev._2024_09_16_web_servlet.models.Usermodel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBconnectionMySQL {
    // Cấu hình URL, username, và password cho MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/_2024_09_16_Web_Servlet";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456789";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            IUserDao userDao = new UserDaoImplement();
//            System.out.println(userDao.findByUsername("nga"));
//            List<Usermodel> usermodelList = userDao.getUsers();
//            for (Usermodel usermodel : usermodelList) {
//                System.out.println(usermodel);
//            }
//            System.out.println(userDao.findById(2));

//            List<Usermodel> usermodelList = userDao.findByRoleId(1);
//            if (!usermodelList.isEmpty()) {
//                for (Usermodel user : usermodelList) {
//                    System.out.println(user);
//                }
//            } else {
//                System.out.println("Không có user nào với roleId được chỉ định.");
//            }

            Usermodel newUser = new Usermodel(43, "ainga", "password123", "nga.doe@example.com", "ái Nga", "nga.pnp", "0123456789", 4, new Date(1));
            userDao.insert(newUser);
            System.out.println("User inserted successfully with ID: " + newUser.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
