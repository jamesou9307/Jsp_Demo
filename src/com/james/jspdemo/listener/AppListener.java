package com.james.jspdemo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fsuser on 2017-07-26.
 */
@WebListener //注册监听器
public class AppListener implements ServletContextListener{//servletlistener监听器


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){//对servletcontext销毁时作出响应

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){//对servletcontext创建时作出响应

        ServletContext servletContext=servletContextEvent.getServletContext();
        Map<String, String> countries=new HashMap<>();
        countries.put("CN","China");
        countries.put("US","United States");
        //实际开发中，将数据库的数据放到servletcontext中
        servletContext.setAttribute("countries",countries);


    }
}
