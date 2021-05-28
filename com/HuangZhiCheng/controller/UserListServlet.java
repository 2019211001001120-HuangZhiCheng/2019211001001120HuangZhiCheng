package com.HuangZhiCheng.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : hzc
 * @date: 2021/5/28 - 05 - 28 - 17:22
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "UserListServlet",value = "/admin/userList")//url
public class UserListServlet extends HttpServlet {
    private static final long serialVersionUID = 2344526781982946090L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/WEB-INF/views/admin/userList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
