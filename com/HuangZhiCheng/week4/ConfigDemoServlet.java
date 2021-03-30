package com.HuangZhiCheng.week4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "ConfigDemoServlet",
            urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name",value ="HuangZhiCheng"),
                @WebInitParam(name="id",value = "2019211001001120")
        }
)
public class ConfigDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer writer = response.getWriter();
        writer.write(getServletConfig().getInitParameter("name")+":");
        writer.write("\n");
        writer.write(getServletConfig().getInitParameter("id")+":");


    }

}
