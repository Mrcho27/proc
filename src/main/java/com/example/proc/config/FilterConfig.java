package com.example.proc.config;

import com.example.proc.filter.FirstFilter;
import com.example.proc.filter.SecondFilter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PatchMapping;

//설정용 클래스를 빈등록한다.
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<FirstFilter> firstFilter(){
//        FilterRegistrationBean은 필터를 등록, 설정하는 클래스이다.
//        예전에는 필터를 web.xml에서 설정하였으나 스프링 부트에서는 JAVA코드를 이용하여 객체로 설정할 수 있게 변경되었다.
        FilterRegistrationBean<FirstFilter> registrationBean = new FilterRegistrationBean<>();

//        우리가 만든 FirstFilter를 등록한다.
        registrationBean.setFilter(new FirstFilter());
//        FirstFilter가 실행되야하는 URL 패턴을 설정한다.
        registrationBean.addUrlPatterns("/user/*");
//        필터의 순서를 설정한다.
        registrationBean.setOrder(1);
//        필터의 이름을 설정한다. 이름을 우리가 사용하지 않지만 필터 사용 순서를 저장할 때 내부적으로 사용된다.
        registrationBean.setName("first");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<SecondFilter> secondFilter(){
        FilterRegistrationBean<SecondFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SecondFilter());
        registrationBean.addUrlPatterns("/user/*");
        registrationBean.setOrder(2);
        registrationBean.setName("second");

        return registrationBean;
    }
}
