package com.HuangZhiCheng.week3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet(){
        System.out.println("I am in constructer");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("I am in init()");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("I am in servise-->doget");

    }

    @Override
    public void destroy(){
        System.out.println("I am in servise--->destroy");
    }
}
