package com.HuangZhiCheng.controller;

import com.HuangZhiCheng.dao.ProductDao;
import com.HuangZhiCheng.model.Category;
import com.HuangZhiCheng.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : hzc
 * @date: 2021/5/14 - 05 - 14 - 19:30
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "AddProductServlet",value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)//16mB
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = -5263662830399590407L;
    private Connection con = null;

    @Override
    public void init() throws ServletException {
        con = (Connection)getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get all parameters
        String productName = request.getParameter("productName");//上传文件名还不能太长不然会报错
        double price = request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId = request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):8;
        String productDescription = request.getParameter("productDescription");

        //get price
        InputStream inputStream = null;
        Part fileParts = request.getPart("picture");
        if(fileParts!=null){
            inputStream = fileParts.getInputStream();
        }
        //set into model
        Product product = new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPicture(inputStream);
        product.setPrice(price);
        product.setCategoryId(categoryId);

        //call same in dao
        ProductDao productDao = new ProductDao();
        System.out.println("-------------"+product.getProductName());
        try {
            int n = productDao.save(product,con);
            response.sendRedirect("productList");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
            String path = "/WEB-INF/views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
