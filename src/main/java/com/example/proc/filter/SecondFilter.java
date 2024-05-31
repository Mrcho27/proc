package com.example.proc.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        init은 initialize의 약자(초기화)
//        즉, 필터를 생성할 때 실행되는 메소드이고
//        필터의 생명주기는 어플리케이션의 실행, 종료와 일치하므로
//        어플리케이션이 실행될 때 필터의 init이 실행된다.
        System.out.println("SecondFilter init()!!!!!!");
    }

    @Override
    public void destroy() {
//        어플리케이션의 종료될 때 destroy가 실행된다.
        System.out.println("SecondFilter destroy()!!!!!!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter에 요청이 지나간다!!!");

//        ServletRequest는 HttpServletRequest의 부모이다.
//        요청에 대한 처리를 할 수 있으나, HTTP 요청에 대한 처리는 HttpServletRequest를 사용해야하므로
//        다운 캐스팅하여 사용한다.
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        Long userId = (Long)session.getAttribute("userId");

        if (userId == null){
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendRedirect("/login");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("SecondFilter에 응답이 지나간다!!!");
    }
}
