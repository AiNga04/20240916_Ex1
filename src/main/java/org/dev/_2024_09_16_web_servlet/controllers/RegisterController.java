package org.dev._2024_09_16_web_servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dev._2024_09_16_web_servlet.dao.Implement.UserDaoImplement;
import org.dev._2024_09_16_web_servlet.models.Usermodel;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(name = "register", value = "/register")
public class RegisterController extends HttpServlet {
    private UserDaoImplement userDao = new UserDaoImplement();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        String hashedPassword = HashUtil.hashPassword(password);
//        Usermodel newUser = new Usermodel(username, hashedPassword);
//
//        if (userDao.register(newUser)) {
//            response.sendRedirect("login.jsp");
//        } else {
//            request.setAttribute("errorMessage", "Tài khoản đã tồn tại!");
//            request.getRequestDispatcher("register.jsp").forward(request, response);
//        }
    }
}
