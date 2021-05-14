package com.HuangZhiCheng.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : hzc
 * @date: 2021/5/14 - 05 - 14 - 19:16
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "ProductListServlet",value = "/admin/productList")
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 9197585364289265302L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }
}
