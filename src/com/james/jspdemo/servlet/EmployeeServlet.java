package com.james.jspdemo.servlet;

import com.james.jspdemo.entity.Address;
import com.james.jspdemo.entity.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.event.AdjustmentEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fsuser on 2017-07-17.
 */
@WebServlet(name = "employeeServlet",urlPatterns = "/employeeServlet.do")
public class EmployeeServlet extends HttpServlet{

    private static  final int serialVersionUID=-5392874;

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        Address address=new Address();
        address.setStreetName("E 28th St");
        address.setStreetNumber("28");
        address.setCity("Minneapolis");
        address.setState("Minnesota");
        address.setZipCode("56068");
        address.setCountry("USA");
        request.setAttribute("address",address);

        Employee employee=new Employee();
        employee.setId("32");
        employee.setName("Karl-Anthony Towns");
        employee.setAddress(address);
        request.setAttribute("employee",employee);

        Map<String,String> country=new HashMap<>();

        country.put("China","Beijing");
        country.put("USA","Washington DC");
        country.put("Japan","Tyoko");

        request.setAttribute("country",country);

        RequestDispatcher rd=request.getRequestDispatcher("/employee.jsp");
        rd.forward(request,response);




    }
}
