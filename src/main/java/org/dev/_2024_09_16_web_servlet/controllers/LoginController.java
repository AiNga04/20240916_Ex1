package org.dev._2024_09_16_web_servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.dev._2024_09_16_web_servlet.models.Usermodel;
import org.dev._2024_09_16_web_servlet.services.IUserService;
import org.dev._2024_09_16_web_servlet.services.implement.UserServiceImplement;
import org.dev._2024_09_16_web_servlet.utils.Constant;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    IUserService service = new UserServiceImplement();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

//        Lấy tham số từ UI
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isRememberMe = false;
        String remember = request.getParameter("remember");

//        Kiểm tra tham số
        if ("on".equals(remember)) {
            isRememberMe = true;
        }
        String alertMsg = "";
        if (username.isEmpty() || password.isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

//        Xử lý bài toán
        Usermodel user = service.login(username, password);
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("account", user);
            if (isRememberMe) {
                saveRemeberMe(response, username);
            }
            response.sendRedirect(request.getContextPath() + "/waiting");
        } else {
            alertMsg =
                    "Tài khoản hoặc mật khẩu không đúng";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
//        if (session != null && session.getAttribute("account") != null) {
//            response.sendRedirect(request.getContextPath() + "/waiting");
//            return;
//        }
//
//        // Check cookie
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("username")) {
//                    session = request.getSession(true);
//                    session.setAttribute("username", cookie.getValue());
//                    response.sendRedirect(request.getContextPath()+ "/waiting");
//                    return;
//                }}}
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    private void saveRemeberMe(HttpServletResponse response, String
            username) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER,
                username);
        cookie.setMaxAge(30 * 60);
        response.addCookie(cookie);
    }
}
