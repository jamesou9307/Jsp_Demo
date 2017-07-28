package com.james.jspdemo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fsuser on 2017-07-27.
 */
@WebListener
public class SessionListener implements HttpSessionListener,ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {//监听servletcontext创建时发生的事

        ServletContext sc=sce.getServletContext();
        sc.setAttribute("userCounter",new AtomicInteger());//在应用创建的时候设置会话数为0


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent hse) {//监听httpsession创建时发生的事
        HttpSession session=hse.getSession();
        ServletContext sc=session.getServletContext();
        AtomicInteger userCounter=(AtomicInteger) sc.getAttribute("userCounter");
        int userCount=userCounter.incrementAndGet();
        System.out.println("userCount incremented to:"+userCount);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {//监听httpsession销毁时发生的事
        HttpSession session=hse.getSession();
        ServletContext sc=session.getServletContext();
        AtomicInteger userCounter=(AtomicInteger)sc.getAttribute("userCounter");
        int userCount=userCounter.decrementAndGet();
        System.out.println("userCount decremented to:"+userCount);


    }
}
