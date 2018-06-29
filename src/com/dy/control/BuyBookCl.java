package com.dy.control;

import com.dy.dao.Book;
import com.dy.dao.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

@WebServlet(name = "BuyBookCl")
public class BuyBookCl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

//        String bookname=request.getParameter("name");
        String id=request.getParameter("id");
//        String price=request.getParameter("price");

        Book bookinfo= DB.getBookById(id);
        HttpSession session=request.getSession();

        //从session中取出mybook
        HashMap<String,Book> hm= (HashMap<String,Book>) session.getAttribute("mybooks");
        //如果第一次购买hm为空
        if(hm==null){
            hm=new LinkedHashMap<>();
            Book book=new Book();
            book.setId(id);
            book.setName(bookinfo.getName());
            book.setNum(1);
            book.setPrice(bookinfo.getPrice());
            hm.put(id,book);
            //把hm放入session
            session.setAttribute("mybooks",hm);
        }else{
            //判断hm中是否有该书
            if(hm.containsKey(id)){
                //表示购买过
                Book book=hm.get(id);
                int bookNum=book.getNum();
                book.setNum(bookNum+1);
            }else{
                Book book=new Book();
                book.setId(id);
                book.setName(bookinfo.getName());
                book.setNum(1);
                book.setPrice(bookinfo.getPrice() );
                hm.put(id,book);
            }
            //更新
            session.setAttribute("mybooks",hm);
        }



        request.getRequestDispatcher("/showMyCart").forward(request,response);

    }
}
