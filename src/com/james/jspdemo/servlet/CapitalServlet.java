package com.james.jspdemo.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fsuser on 2017-07-18.
 */
@WebServlet(name = "capitalServlet" ,urlPatterns = "/capitalServlet.do")
public class CapitalServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        Map<String,String> capitals=new HashMap<>();
        capitals.put("China","Beijing");
        capitals.put("Japan","Tyoko");
        capitals.put("USA","Washington DC");
        capitals.put("France","Paris");
        request.setAttribute("capitals",capitals);


        Map<String,String[]> cities=new HashMap<>();

        cities.put("China",new String[]{"Beijing","Shanghai"});
        cities.put("UK",new String[]{"London","Manchester","Liverpool"});
        cities.put("Japan",new String[]{"Tyoko","Osaka","Hakata"});
        cities.put("USA",new String[]{"Washingtong DC","Los Angeles","New York","Chicago"});
        request.setAttribute("cities",cities);

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/capitals.jsp");
        requestDispatcher.forward(request,response);
    }
}
