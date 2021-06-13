package com.hzc.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : hzc
 * @date: 2021/6/13 - 06 - 13 - 10:51
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "HitCountServlet",value = "/HitCountServlet")
public class HitCountServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        getServletContext().setAttribute("count",0);//set the contextAttribute count=0
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //when a request in,count++
        int count = (int)request.getServletContext().getAttribute("count");
        count++;
        request.getServletContext().setAttribute("count",count);
        request.getRequestDispatcher("/lab3/count.jsp").forward(request,response);
    }
}
