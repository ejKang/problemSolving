package com.joo.book.springboot.springbootwebservice.config;

import java.util.List;

import com.joo.book.springboot.springbootwebservice.config.auth.LoginUserArgumentResolver;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer { 
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override // HandlerMethodArgumentResolver는 항상 WebMvcConfigurer의 addArgumentResulvers()를 통해 추가해야 한다 
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserArgumentResolver);
    }
}
