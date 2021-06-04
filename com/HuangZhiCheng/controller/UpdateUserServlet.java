package com.HuangZhiCheng.controller;

import com.HuangZhiCheng.dao.UserDao;
import com.HuangZhiCheng.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : hzc
 * @date: 2021/4/23 - 04 - 23 - 11:14
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "UpdateUserServlet",value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con;
    private static final long serialVersionUID = -4666104223234913512L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        String email = request.getParameter("Email");
        String gender = request.getParameter("gender");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String birthdate = request.getParameter("birthDate");
        SimpleDateFormat sim = new SimpleDateFormat();
        Date birthDate = null;
        try {
            birthDate = sim.parse(birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthDate(birthDate);
        user.setPassword(password);
        UserDao userDao = new UserDao();
        try {
            int n =userDao.updateUser(con,user);
            User updatedUser = userDao.findById(con,id);
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            session.setAttribute("user",updatedUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("accountDetails").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    public void init() throws ServletException {
        con = (Connection)getServletContext().getAttribute("con");
    }
}
