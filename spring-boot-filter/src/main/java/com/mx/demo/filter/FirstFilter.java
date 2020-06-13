package com.mx.demo.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Order(1)
//@WebFilter(filterName = "firstFilter", urlPatterns = "/api/*")
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("First,检验接口是否被调用，尝试获取contentType如下： " + response.getContentType());
        chain.doFilter(request, response);//这步使得请求能够继续传导下去，如果没有的话，请求就在此结束
        System.out.println("First,检验接口是否被调用，尝试获取contentType如下： " + response.getContentType());
    }
}
