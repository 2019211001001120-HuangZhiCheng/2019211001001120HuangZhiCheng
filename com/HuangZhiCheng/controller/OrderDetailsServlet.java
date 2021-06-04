package com.HuangZhiCheng.controller;

import com.HuangZhiCheng.dao.OrderDao;
import com.HuangZhiCheng.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * @author : hzc
 * @date: 2021/6/4 - 06 - 04 - 13:29
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "OrderDetailsServlet",value = "orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 9136699598813636827L;
    private Connection con;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection)getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = request.getParameter("orderId")!=null?
                Integer.parseInt(request.getParameter("orderId")):0;
        Item item = new Item();
        OrderDao orderDao = new OrderDao();
        List<Item> items = orderDao.findItemsByOrderId(con,orderId);
        request.setAttribute("itemList",item);
        String path = "orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
