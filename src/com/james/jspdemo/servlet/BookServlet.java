package com.james.jspdemo.servlet;

import com.james.jspdemo.entity.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

/**
 * Created by fsuser on 2017-07-18.
 */
@WebServlet(name = "bookServlet",urlPatterns = "/bookServlet.do")
public class BookServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        Book book1 =new Book("978-0980839616","core java",88);
        Book book2 =new Book("979-0980839616","core c++",80);
        Book book3 =new Book("980-0980839616","core android",90);
        List<Book> books=new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        request.setAttribute("books",books);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/books.jsp");
        requestDispatcher.forward(request,response);
    }
}
