package com.james.jspdemo.filter;

import com.james.jspdemo.wrapper.ChangeParameterHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by fsuser on 2017-08-02.
 */
@WebFilter(filterName = "changeFilter",urlPatterns = {"/changeServlet.do"})
public class ChangeParameterFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        ChangeParameterHttpServletRequestWrapper wrapper=new ChangeParameterHttpServletRequestWrapper(httpServletRequest);
        filterChain.doFilter(wrapper,servletResponse);
    }
}
