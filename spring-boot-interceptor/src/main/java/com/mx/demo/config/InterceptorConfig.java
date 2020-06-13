package com.mx.demo.config;

import com.mx.demo.interceptor.FirstInterceptor;
import com.mx.demo.interceptor.SecondInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private FirstInterceptor firstInterceptor;

    @Autowired
    private SecondInterceptor secondInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 1.加入的顺序就是拦截器执行的顺序，
        // 2.按顺序执行所有拦截器的preHandle
        // 3.所有的preHandle 执行完再执行全部postHandle 最后是postHandle
        registry.addInterceptor(firstInterceptor).addPathPatterns("/api/**");
        registry.addInterceptor(secondInterceptor).addPathPatterns("/api/**").excludePathPatterns("/api/login");
    }
}
