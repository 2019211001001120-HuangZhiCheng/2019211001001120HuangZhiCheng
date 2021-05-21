package com.HuangZhiCheng.controller;

import com.HuangZhiCheng.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author : hzc
 * @date: 2021/5/20 - 05 - 20 - 15:45
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "GetImgServlet",value = "/getImg")
public class GetImgServlet extends HttpServlet {
    private Connection con;

    @Override
    public void init() throws ServletException {
        con = (Connection)getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get from request
        int id = 0;
        if(request.getParameter("id")!=null)
            id = Integer.parseInt(request.getParameter("id"));

        ProductDao productDao = new ProductDao();
        byte[] imgByte = new byte[0];
        try {
            imgByte = productDao.getPictureById(id, con);
            if(imgByte!=null){
//                write into response
                response.setContentType("image/gif");
                OutputStream out = response.getOutputStream();
                out.write(imgByte);
                out.flush();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
