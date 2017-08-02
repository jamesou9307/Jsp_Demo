package com.james.jspdemo.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by fsuser on 2017-08-02.
 */
public class ChangeParameterHttpServletRequestWrapper extends HttpServletRequestWrapper{

   private HttpServletRequest request;

    public ChangeParameterHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        return changeParameter(request.getParameter(name));
    }

    private String changeParameter(){

        return "your parameter is changed";
    }
    private String changeParameter(String value){

        String value1=value+"_123";
        return value1;
    }
}
