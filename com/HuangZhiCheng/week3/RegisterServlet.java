package com.HuangZhiCheng.week3;

import com.HuangZhiCheng.dao.UserDao;
import com.HuangZhiCheng.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegisterServlet extends HttpServlet {
    Connection con = null;
    private static final long serialVersionUID = 3582264699128982106L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        request 对象接收来自用户端对服务器的指令，response对象从服务器输出信息到用户端
         */
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();
        UserDao userDao = new UserDao();
        user.setUsername(request.getParameter("username"));//接收从网页收到的Username=**的值
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setGender(request.getParameter("gender"));
        try {
            user.setBirthDate(dft.parse(request.getParameter("birthDate")));
            userDao.insertUser(con,user);
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }

//        PrintWriter writer = response.getWriter();
//        writer.println("<br/>Username:"+Username);//可识别html语言
//        writer.println("<br/>Password:"+Password);
//        writer.println("<br/>Email:"+Email);
//        writer.println("<br/>sex:"+sex);
//        writer.println("<br/>birthday:"+birthday);
//        writer.close();
        //week-9
        response.sendRedirect("login");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);

    }

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }
}
