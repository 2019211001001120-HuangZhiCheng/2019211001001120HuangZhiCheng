package com.hzc.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : hzc
 * @date: 2021/6/13 - 06 - 13 - 11:06
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "CalServlet",value = "/lab3/CalServlet")
public class CalServlet extends HttpServlet {
    //param: firstVal secondVal name

    /*相加
    * */
    public Double add(double firstVal,double secondVal){
        return firstVal+secondVal;
    }

    /*相减
     * */
    public Double subtract(double firstVal,double secondVal){
        return firstVal-secondVal;
    }

    /*相乘
     * */
    public Double multiply(double firstVal,double secondVal){
        return firstVal*secondVal;
    }

    /*相除
     * */
    public Double divide(double firstVal,double secondVal){
        if(secondVal==0){
            return null;
        }
        return firstVal/secondVal;
    }

    /*计算名字长度
    * */
    public int computeLength(String name){
        return name.length();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取属性值 firstVal secondVal name
        String firstVal = request.getParameter("firstVal");
        String secondVal = request.getParameter("secondVal");
        String name = request.getParameter("name");
        //获取进行的方法 Add Subtract Multiply ComputeLength Reset
        String add = request.getParameter("Add");
        String subtract = request.getParameter("Subtract");
        String multiply = request.getParameter("Multiply");
        String divide = request.getParameter("divide");
        String computeLength = request.getParameter("ComputeLength");
        String reset = request.getParameter("Reset");
        Cookie cookie=null,cookie1=null,resetcookie=null,resetcookie1=null;
        //进行判断哪个不为空就进行哪个方法
        if(add!=null){
            //设置两个cookie就是防止前端输出重复信息
            try {
                double firstVald  = Double.parseDouble(firstVal);
                double secondVald = Double.parseDouble(secondVal);
                Double sum = add(firstVald, secondVald);
                cookie = new Cookie("value",sum.toString());
                cookie1 = new Cookie("error","");
            } catch (NumberFormatException e) {
                cookie = new Cookie("value","");
                cookie1 = new Cookie("error","inputError");
            }
        }else if(subtract!=null){
            try {
                double firstVald  = Double.parseDouble(firstVal);
                double secondVald = Double.parseDouble(secondVal);
                Double sum = subtract(firstVald, secondVald);
                cookie = new Cookie("value",sum.toString());
                cookie1 = new Cookie("error","");
            } catch (NumberFormatException e) {
                cookie = new Cookie("value","");
                cookie1 = new Cookie("error","inputError");
            }
        }else if(multiply!=null){
            try {
                double firstVald  = Double.parseDouble(firstVal);
                double secondVald = Double.parseDouble(secondVal);
                Double sum = multiply(firstVald, secondVald);
                cookie = new Cookie("value",sum.toString());
                cookie1 = new Cookie("error","");
            } catch (NumberFormatException e) {
                cookie = new Cookie("value","");
                cookie1 = new Cookie("error","inputError");
            }
        }else if(divide!=null){
            try {
                double firstVald  = Double.parseDouble(firstVal);
                double secondVald = Double.parseDouble(secondVal);
                Double sum = divide(firstVald, secondVald);
                cookie = new Cookie("value",sum.toString());
                cookie1 = new Cookie("error","");
            } catch (Exception e) {
                cookie = new Cookie("value","");
                cookie1 = new Cookie("error","inputError");
            }
        }else if(computeLength!=null){
                cookie = new Cookie("length",computeLength(name)+"");
                cookie1 = new Cookie("lengthError","");
        }else if(reset!=null){
            //重置按钮全部置空
            cookie = new Cookie("value","");
            cookie1 = new Cookie("error","");
            resetcookie = new Cookie("length","");
            resetcookie1 = new Cookie("lengthError","");
        }
        response.addCookie(cookie);
        response.addCookie(cookie1);
        if(resetcookie!=null&&resetcookie1!=null){
            response.addCookie(resetcookie);
            response.addCookie(resetcookie1);
        }
        response.sendRedirect(request.getContextPath()+"/lab3/cal.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
