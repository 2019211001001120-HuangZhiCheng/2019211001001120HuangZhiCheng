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
 * @date: 2021/5/21 - 05 - 21 - 9:29
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "ShopServlet",value = "/shop")
public class ShopServlet extends HttpServlet {
    private static final long serialVersionUID = -7283937807369873635L;
    private Connection con;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection)getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set all category into request
        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //set all product into request
        ProductDao productDao = new ProductDao();
        try {
            //show all product
            if(request.getParameter("categoryId")==null){
                List<Product> productList = productDao.findAll(con);
                request.setAttribute("productList",productList);
            }else {
                //show only one
                int catId = Integer.parseInt(request.getParameter("categoryId"));
                List<Product> productList = productDao.findByCategoryId(catId,con);
                request.setAttribute("productList",productList);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path = "/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);

        //forword
    }
}
