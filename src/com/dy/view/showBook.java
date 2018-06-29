package com.dy.view;

import com.dy.dao.Book;
import com.dy.dao.DB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class showBook extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ArrayList<Book> mydb= DB.getDB();
        out.println("<style type=\"text/css\">\n" +
                "\ttable{\n" +
                "\t\tborder-collapse: collapse;\n" +
                "\t}\n" +
                "\ttd{\n" +
                "\ttext-align: center;\n" +
                "\tborder: 1px solid black;\n" +
                "\twidth: 80px;\n" +
                "\theight: 40px;\n" +
                "     }\n" +
                "\t</style>");
        out.println("<table>\n" +
                "\t\t\t<th>欢迎购书</th>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td>书名</td>\n" +
                "\t\t\t\t<td>价格</td>\n" +
                "\t\t\t\t<td>库存</td>\n" +
                "\t\t\t\t<td>购买</td>\n" +
                "\t\t\t</tr>\n" );
        for(Book book:mydb){


        out.println(
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td>"+book.getName()+"</td>\n" +
                "\t\t\t\t<td>"+book.getPrice()+"</td>\n" +
                "\t\t\t\t<td>8</td>\n" +
                "\t\t\t\t<td><a href='/myCart/BuyBookCl?id="+book.getId()+"'>购买此书</a></td>\n" +
                "\t\t\t</tr>\n");
    }
    }
}
