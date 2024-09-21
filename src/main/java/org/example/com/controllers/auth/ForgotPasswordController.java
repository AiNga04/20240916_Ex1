package org.example.com.controllers.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.com.services.IUserService;
import org.example.com.services.impl.UserServiceImpl;
import org.example.com.utils.Constant;

import java.io.IOException;

@WebServlet("/forgot-password")
public class ForgotPasswordController extends HttpServlet {
    private final IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constant.Path.FORGOT_PASSWORD).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String email = req.getParameter("email");
        String newPassword = req.getParameter("password");
        String reNewPassword = req.getParameter("re-password");

        String alertMsg = validateInputs(email, newPassword, reNewPassword);
        if (alertMsg != null) {
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.Path.FORGOT_PASSWORD).forward(req, resp);
            return;
        }

        if (userService.changePassword(email, newPassword)) {
            req.getSession().setAttribute("success", "You have reset password successfully, please login!");
            resp.sendRedirect(req.getContextPath() + "/auth/login");
        } else {
            req.setAttribute("alert", "Unable to reset your password!");
            req.getRequestDispatcher(Constant.Path.FORGOT_PASSWORD).forward(req, resp);
        }
    }

    private String validateInputs(String email, String newPassword, String reNewPassword) {
        if (!userService.checkExistEmail(email)) {
            return "Your email does not exist";
        }
        if (!newPassword.equals(reNewPassword)) {
            return "Password and retype password do not match!";
        }
        return null;
    }
}
