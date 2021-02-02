package com.chongaizhen.springcloud.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chongaizhen
 * @date 2021-02-02
 */
@Configuration
public class FeignSupportConfig {

    /**
     * feign请求拦截器
     * @return
     */
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignBasicAuthRequestInterceptor();
    }
}