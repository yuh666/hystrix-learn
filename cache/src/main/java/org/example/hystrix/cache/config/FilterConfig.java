package org.example.hystrix.cache.config;

import org.example.hystrix.cache.filter.HystrixContextFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

//    @Bean
//    public FilterRegistrationBean<HystrixContextFilter> filterRegistrationBean() {
//        FilterRegistrationBean<HystrixContextFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new HystrixContextFilter());
//        registrationBean.addUrlPatterns("/*");
//        return registrationBean;
//    }
}
