package com.HuangZhiCheng.week4;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "JdbcDemoServlet",
        urlPatterns = {"/Jdbc"},//把各种属性从.xml文件的配置调到类前面
        initParams = {
                @WebInitParam(name="driver",value ="com.mysql.cj.jdbc.Driver"),
                @WebInitParam(name="url",value ="jdbc:mysql://127.0.0.1:3306/mytestdb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC"),
                @WebInitParam(name="user",value ="root"),
                @WebInitParam(name="password",value ="root")
        }
)
public class JdbcDemoServlet extends HttpServlet {
    Connection con=null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--> i am in doget");
        String sql="select * from usertable";
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                System.out.print(resultSet.getInt("id"));
            }

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
            System.out.println("--> con");
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
        //初始化不能随便把con接口close掉
    }

    @Override
    public void destroy() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }//只要在服务器关掉之后close掉就行
    }
}
