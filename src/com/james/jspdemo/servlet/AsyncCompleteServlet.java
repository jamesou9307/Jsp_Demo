package com.james.jspdemo.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by fsuser on 2017-08-03.
 */
@WebServlet(name = "asyncCompleServlet",urlPatterns = "/asyncCompleteSevlet.do",asyncSupported = true)
public class AsyncCompleteServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        final PrintWriter out=resp.getWriter();
        out.println("<html><head><title>"+"Async Servlet</title></head>");
        out.println("<body><div id='progress'></div>");
        AsyncContext asyncContext=req.startAsync();
        asyncContext.setTimeout(60000);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    out.println("<script>document.getElementById('progress').innerHTML='"+(i*10)+"% complete' ");
                    out.println("</script>");
                    out.flush();
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException ie){

                    }
                }
                out.println("<script>document.getElementById('progress').innerHTML='DONE'</script>");
                out.println("</body></html>");
                //告诉服务器该任务已完成
                asyncContext.complete();


            }
        });
    }
}
