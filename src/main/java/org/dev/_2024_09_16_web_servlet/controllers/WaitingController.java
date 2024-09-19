package org.dev._2024_09_16_web_servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.dev._2024_09_16_web_servlet.models.Usermodel;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(name = "waiting", value = "/waiting")
public class WaitingController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        if(session != null && session.getAttribute("account") != null) {
            Usermodel u=(Usermodel) session.getAttribute("account");
            req.setAttribute("username", u.getUsername());
            if(u.getRoleid()==2) {
                resp.sendRedirect(req.getContextPath()+"/admin/home");
            }else if(u.getRoleid()==3) {
                resp.sendRedirect(req.getContextPath()+"/manager/home");
            }else if(u.getRoleid()==4) {
                resp.sendRedirect(req.getContextPath()+"/seller/home");
            }else if(u.getRoleid()==5) {
                resp.sendRedirect(req.getContextPath()+"/shipper/home");
            }else if(u.getRoleid()==1) {
                resp.sendRedirect(req.getContextPath()+"/user/home");
            }else {
                resp.sendRedirect(req.getContextPath()+"/home");
            }
        }else {
            resp.sendRedirect(req.getContextPath()+"/login");
        }}
    }
