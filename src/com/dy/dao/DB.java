package com.dy.dao;

import java.util.ArrayList;

//用ArrayList模拟一个内存数据库
public class DB {

    private static ArrayList al=null;


    private  DB(){}
    static{
        al=new ArrayList<Book>();
        Book book1=new Book();
        book1.setId("1");
        book1.setName("java");
        book1.setPrice(30);

        Book book2=new Book();
        book2.setId("2");
        book2.setName("C");
        book2.setPrice(50);

        Book book3=new Book();
        book3.setId("3");
        book3.setName("VB");
        book3.setPrice(82);

        Book book4=new Book();
        book4.setId("4");
        book4.setName("servlet");
        book4.setPrice(60);
        al.add(book1);
        al.add(book2);
        al.add(book3);
        al.add(book4);
    }
    public static ArrayList getDB(){
        return al;
    }

    public static Book getBookById(String id){

        Book book=null;
        boolean b=false;
        for(int i=0;i<al.size();i++) {
            book = (Book) al.get(i);
            if (book.getId().equals(id)) {
                b=true;
                break;
            }
        }
        if(b) {
            return book;
        }else{
            return null;
        }
    }
}
