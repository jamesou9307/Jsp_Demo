package com.james.jspdemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import com.james.jspdemo.wrapper.AutoCorrectHttpServletRequestWrapper;
import java.io.IOException;
import java.util.*;

/**
 * Created by fsuser on 2017-08-01.
 */
/*@WebFilter(filterName = "autoCorrectFilter",urlPatterns = {
        "*//*"
})*/
public class AutoCorrectFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest=(HttpServletRequest)request;
        AutoCorrectHttpServletRequestWrapper wrapper=new
                AutoCorrectHttpServletRequestWrapper(httpServletRequest);
        filterChain.doFilter(wrapper,response);


    }
}

