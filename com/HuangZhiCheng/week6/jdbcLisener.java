package com.HuangZhiCheng.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcLisener implements ServletContextListener {
    private Connection con = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servlet = servletContextEvent.getServletContext();
        String driver = servlet.getInitParameter("driver");
        String url = servlet.getInitParameter("url");
        String user = servlet.getInitParameter("user");
        String password = servlet.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        servlet.setAttribute("con",con);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
