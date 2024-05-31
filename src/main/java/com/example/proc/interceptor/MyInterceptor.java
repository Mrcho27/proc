package com.example.proc.interceptor;

import com.example.proc.mapper.TimeMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Component
@RequiredArgsConstructor
public class MyInterceptor implements HandlerInterceptor {
    private final TimeMapper timeMapper;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        반환 타입이 boolean인데 true를 반환하면 요청 처리를 진행하고
//        false를 반환하면 요청처리를 중지한다.(컨트롤러에 요청이 도달하지 못한다.)
        String time = timeMapper.selectTime();
        request.setAttribute("time", time);
        log.info("time : {}", time);
        log.info("preHandle() 실행!");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null){
            String viewName = modelAndView.getViewName();
            log.info("viewName : {}", viewName);
        }

        log.info("postHandle() 실행!!!");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion() 실행!!!!");
    }
}
