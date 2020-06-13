package com.mx.demo.config;

import com.mx.demo.filter.FirstFilter;
import com.mx.demo.filter.SecondFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean<FirstFilter> firstFilter() {
        FilterRegistrationBean<FirstFilter> filterRegBean = new FilterRegistrationBean<>();
        filterRegBean.setFilter(new FirstFilter());
        filterRegBean.addUrlPatterns("/api/*"); // 匹配模式
        filterRegBean.setOrder(1); // 执行顺序，数字小的先执行
        return filterRegBean;
    }

    @Bean
    public FilterRegistrationBean<SecondFilter> secondFilter() {
        FilterRegistrationBean<SecondFilter> filterRegBean = new FilterRegistrationBean<>();
        filterRegBean.setFilter(new SecondFilter());
        filterRegBean.addUrlPatterns("/api/*"); // 匹配模式
        filterRegBean.setOrder(2); // 执行顺序
        return filterRegBean;
    }
}
