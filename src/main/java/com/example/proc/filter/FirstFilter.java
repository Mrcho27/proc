package com.example.proc.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter에 요청이 지나간다.");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FirstFilter에 응답이 지나간다.");

    }
}
