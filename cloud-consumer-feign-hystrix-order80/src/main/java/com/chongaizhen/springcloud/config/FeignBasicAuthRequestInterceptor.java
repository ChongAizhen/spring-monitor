package com.chongaizhen.springcloud.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @author chongaizhen
 * @date 2021-02-02
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {

    //线程ID常量
    private static final String THREAD_ID = "THREAD_ID";

    @Override
    public void apply(RequestTemplate requestTemplate) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (Objects.isNull(attributes)) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                requestTemplate.header(name, values);
            }
        }

        requestTemplate.header(THREAD_ID, MDC.get(THREAD_ID));
    }
}