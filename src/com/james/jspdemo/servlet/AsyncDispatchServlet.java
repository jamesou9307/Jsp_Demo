package com.james.jspdemo.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fsuser on 2017-08-02.
 */
@WebServlet(name = "asyncDispatchServlet",urlPatterns = "/asyncServlet.do",asyncSupported = true)/*asyncSupported = true:支持异步处理*/
public class AsyncDispatchServlet extends HttpServlet{

    private static final long serialVersionUID=222L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //启动一个asynccontext实例shoudao
        final AsyncContext asyncContext=req.startAsync();

        /*
        * mainThread:当前线程（doGet方法所在的线程）
        * workThread:新建的工作线程
        * */
        req.setAttribute("mainThread",Thread.currentThread().getName());
        asyncContext.setTimeout(5000);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException ie){

                }
                req.setAttribute("workThread",Thread.currentThread().getName());
                asyncContext.dispatch("/threadName.jsp");
            }
        });
    }
}
