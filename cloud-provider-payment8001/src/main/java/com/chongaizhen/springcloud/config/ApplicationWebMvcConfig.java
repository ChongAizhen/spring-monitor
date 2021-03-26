package com.chongaizhen.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chongaizhen
 * @date 2021-03-26
 */
@Configuration
public class ApplicationWebMvcConfig implements WebMvcConfigurer {

    /**
     * 注解LogInterceptor类到IOC容器中
     */
    @Bean
    public LogInterceptor logInterceptor() {
        return new LogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(logInterceptor());
    }
}