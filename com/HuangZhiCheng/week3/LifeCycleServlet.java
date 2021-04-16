package com.HuangZhiCheng.week6;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    private Connection con = null;
    private static final long serialVersionUID = 6958143394670602948L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        PreparedStatement pre=null;
        String sql="select * from usertable where username=? and password=?";
        try {
            pre = con.prepareStatement(sql);
            pre.setString(1,username);
            pre.setString(2,password);
            ResultSet resultSet = pre.executeQuery();
            if(resultSet.next()){
                request.setAttribute("id",resultSet.getInt("id"));
                request.setAttribute("username",resultSet.getString("username"));
                request.setAttribute("password",resultSet.getString("password"));
                request.setAttribute("email",resultSet.getString("email"));
                request.setAttribute("gender",resultSet.getString("gender"));
                request.setAttribute("birthdate",resultSet.getDate("birthdate"));
                request.getRequestDispatcher("userinfo.jsp").forward(request,response);
            }else {
                request.setAttribute("message","Usename or Password Error");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    public void destroy() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        con =(Connection) getServletContext().getAttribute("con");
    }
}
