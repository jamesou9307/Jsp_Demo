package com.james.jspdemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by fsuser on 2017-07-28.
 */
@WebFilter(filterName = "logFilter",urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "logFileName",value = "log.txt"),
                @WebInitParam(name = "prefix",value = "URI:")

        }
)
public class LogFilter implements Filter{

    private PrintWriter logger;
    private String prefix;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        prefix=filterConfig.getInitParameter("prefix");
        String logFileName=filterConfig.getInitParameter("logFileName");

        String appPath=filterConfig.getServletContext().getRealPath("/");//获取工作目录


        System.out.println("logFileName:"+logFileName);

        try{
            logger=new PrintWriter(new File(appPath,logFileName));
        }catch (FileNotFoundException fne){
            fne.printStackTrace();
            throw new ServletException(fne.getMessage());
        }


    }

    @Override
    public void destroy() {//销毁filter
        System.out.println("destroying filter");
        if(logger!=null){
            logger.close();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoggingFilter,doFilter");
        HttpServletRequest hsr=(HttpServletRequest) servletRequest;
        logger.println(new Date()+"  "+prefix+"  "+hsr.getRequestURI());
        logger.flush();
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
