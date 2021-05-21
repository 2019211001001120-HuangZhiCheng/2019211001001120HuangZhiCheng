package com.HuangZhiCheng.controller;

import com.HuangZhiCheng.dao.ProductDao;
import com.HuangZhiCheng.model.Category;
import com.HuangZhiCheng.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : hzc
 * @date: 2021/5/21 - 05 - 21 - 10:08
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "ProductDetailsServlet",value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 6419963511822249143L;
    private Connection con;

    @Override
    public void init() throws ServletException {
        con = (Connection)getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList = Category.findAllCategory(con);//static
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(request.getParameter("id")!=null){
                int productId = Integer.parseInt(request.getParameter("id"));
                ProductDao productDao = new ProductDao();
                Product product = productDao.findById(productId,con);
                request.setAttribute("p",product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path = "/WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }
}
