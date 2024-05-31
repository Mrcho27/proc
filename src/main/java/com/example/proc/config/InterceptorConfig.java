package com.example.proc.config;

import com.example.proc.interceptor.MyInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// WebMvcConfigurer 인터페이스는 스프링 MVC 웹 설정을 정의할 수 있는 인터페이스이다.
// 인터셉터 설정을 위해 필요하다.
@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistry객체는 인터셉터를 등록 및 관리하는 객체이다.
//        addInterceptor() 우리가 만든 인터셉터를 등록한다.
        registry.addInterceptor(myInterceptor)
                // URL패턴을 등록하여 특정 URL패턴에서 등록한 인터셉터가 실행되도록 한다.
                // 패턴 설정시 /*과 /**의 차이
                // /* 하위 경로 1개 /user/login
                // /** 하위 경로가 2개 이상 /user/test/login
                .addPathPatterns("/user/**")
                // 특정 URL에서는 등록한 인터셉터가 실행되지 않도록 제외시킨다.
                .excludePathPatterns("/in");
//              .order(1);

//        여러 인터셉터를 등록할 수 있다.
//        registry.addInterceptor(myInterceptor)
//                .addPathPatterns("/board/**")
//                .excludePathPatterns("/in")
//                .order(2);
    }
}
