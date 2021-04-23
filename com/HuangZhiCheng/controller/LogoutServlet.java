package com.HuangZhiCheng.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : hzc
 * @date: 2021/4/23 - 04 - 23 - 10:34
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "LogoutServlet",value = "/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 8842894826923324313L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(false).invalidate();
        request.setAttribute("message","you have successfully Logged out.");
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }
}
