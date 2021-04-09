package com.HuangZhiCheng.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String url = (String)request.getParameter("search");//get information from jsp
        String txt = (String)request.getParameter("text");
        if(null==txt||"".equals(txt)){
            response.sendRedirect("index.jsp");//return home page
        }else {
            if("baidu".equals(url)){
                response.sendRedirect("http://www.baidu.com/s?wd="+txt);
            }else if("bing".equals(url)){
                response.sendRedirect("http://cn.bing.com/search?q="+txt);
            }else if ("google".equals(url)){
                response.sendRedirect("htpp://www.google.com/search?q="+txt);
            }
        }
    }
}
