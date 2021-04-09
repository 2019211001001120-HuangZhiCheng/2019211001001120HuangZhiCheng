package com.HuangZhiCheng.week6;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    Connection con = null;
    private static final long serialVersionUID = 3582264699128982106L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        request 对象接收来自用户端对服务器的指令，response对象从服务器输出信息到用户端
         */
        this.doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "insert into usertbale values (?,?)";
        PreparedStatement pre = null;
        try {
            pre = con.prepareStatement(sql);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }

    @Override
    public void init() throws ServletException {
        Connection con =(Connection) getServletContext().getAttribute("con");
    }
}
