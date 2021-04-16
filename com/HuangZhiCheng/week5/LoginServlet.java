package com.HuangZhiCheng.week5;

import com.HuangZhiCheng.dao.UserDao;
import com.HuangZhiCheng.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
    private Connection con = null;
    private static final long serialVersionUID = 6958143394670602948L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();

        try {
            User user = userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }else {
                request.setAttribute("message","username or password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        PrintWriter writer = response.getWriter();
//        PreparedStatement pre=null;
//        String sql="select * from usertable where username=? and password=?";
//        try {
//            pre = con.prepareStatement(sql);
//            pre.setString(1,username);
//            pre.setString(2,password);
//            ResultSet resultSet = pre.executeQuery();
//            if(resultSet.next()){
//                    writer.println("Login Success!!!");
//                    writer.println(resultSet.getString("username"));
//                    writer.println(resultSet.getString("password"));
//            }else {
//                writer.println("Login Fail!!!");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
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
        con = (Connection)getServletContext().getAttribute("con");
    }
}
