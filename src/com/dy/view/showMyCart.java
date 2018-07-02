package com.dy.view;

import com.dy.dao.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

@WebServlet(name = "showMyCart")
public class showMyCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        //从session中取出购买数
        HashMap<String,Book> mybooks= (HashMap<String,Book>) request.getSession().getAttribute("mybooks");

        out.println("<h1>您的购物车有以下商品：</h1><br/>");

       Iterator iterator=mybooks.keySet().iterator();
        int total=0;
        while(iterator.hasNext()){
            String key= (String) iterator.next();
            Book book=mybooks.get(key)     ;
            total +=book.getNum()*book.getPrice();
            out.println(book.getName()+" "+book.getNum()+"<br/>");

        }
        out.println("您购买的商品总价格为："+total+"<br/>");

        //URL地址重写
        String url=response.encodeURL("/myCart/showBook");
        out.println("<a href='"+url+"'>返回购买页面</a>");

    }
}
