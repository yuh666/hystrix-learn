package org.example.hystrix.cache.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.example.hystrix.cache.filter.HystrixContextFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
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

    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registration.addUrlMappings("/hystrix.stream");
        return registration;
    }
}
