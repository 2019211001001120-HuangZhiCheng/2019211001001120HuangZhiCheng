package com.HuangZhiCheng.week5;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value ="/login",
        initParams = {
                @WebInitParam(name="driver",value ="com.mysql.cj.jdbc.Driver"),
                @WebInitParam(name="url",value ="jdbc:mysql://127.0.0.1:3306/mytestdb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC"),
                @WebInitParam(name="user",value ="root"),
                @WebInitParam(name="password",value ="root")
        }
)

public class LoginServlet extends HttpServlet {
    private Connection con = null;
    private static final long serialVersionUID = 6958143394670602948L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    writer.println("Login Success!!!");
                    writer.println(resultSet.getString("username"));
                    writer.println(resultSet.getString("password"));
            }else {
                writer.println("Login Fail!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        ServletConfig config = getServletConfig();//其实就是获得配置文件的对象，只不过这是一个接口
        String driver = config.getInitParameter("driver");//通过名称(name)获得值(value)
        String url = config.getInitParameter("url");
        String user = config.getInitParameter("user");
        String password = config.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);

        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }


    }
}
