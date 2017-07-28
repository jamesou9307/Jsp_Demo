package com.james.jspdemo.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by JAMES on 2017/7/28.
 */
public class PerfStatListener implements ServletRequestListener{//servletRequest请求监听器

    @Override
    public void requestInitialized(ServletRequestEvent sre) {//servletrequest发出时响应的方法
        ServletRequest sr=sre.getServletRequest();
        sr.setAttribute("start",System.nanoTime());//存入创建request时的当前系统时间

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {//销毁servletRequest时响应的方法

        ServletRequest sr=sre.getServletRequest();
        long start=(long)sr.getAttribute("start");//获取创建request时的时间
        long end=System.nanoTime();//销毁servletrequest时的系统时间
        HttpServletRequest hsr=(HttpServletRequest)sr;
        String uri=hsr.getRequestURI();
        System.out.println("time taken to execute "+uri+":"+(end-start)/1000+"microseconds");
    }
}
