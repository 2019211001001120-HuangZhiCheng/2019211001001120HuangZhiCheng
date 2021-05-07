package com.HuangZhiCheng.controller;

import com.HuangZhiCheng.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author : hzc
 * @date: 2021/5/1 - 05 - 01 - 20:08
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "AdminHomeServlet",value = "/admin/home")
public class AdminHomeServlet extends HttpServlet {
    private static final long serialVersionUID = -4061622085883034698L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session!=null&&session.getAttribute("user")!=null){
            User user = (User)session.getAttribute("user");
            if("admin".equals(user.getUsername())){
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request,response);

            }else {
                session.invalidate();
                request.setAttribute("message","Unauthorized Access Admin Module!!!");
                request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);

            }
        }else {
            request.setAttribute("message","Please login as admin!!!");
            request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
        }

    }
}
