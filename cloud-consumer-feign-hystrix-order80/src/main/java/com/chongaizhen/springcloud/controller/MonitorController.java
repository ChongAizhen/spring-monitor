package com.chongaizhen.springcloud.controller;

import com.chongaizhen.springcloud.service.MonitorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @auther chongaizhen
 * @create 2020-02-20 11:57
 */
@RestController
@Slf4j
public class MonitorController
{
    @Resource
    private MonitorService monitorService;

    @GetMapping("/test/header")
    public String testHeader(HttpServletRequest httpServletRequest)
    {
        String token = httpServletRequest.getHeader("token");
        log.info("token的值为{}", token);
        String result = monitorService.testHeader(1);
        return result;
    }

    @GetMapping("/test/header/annotation")
    public String testHeaderAnnotation(HttpServletRequest httpServletRequest)
    {
        String token = httpServletRequest.getHeader("token");
        String result = monitorService.testHeaderAnnotation(1, token);
        return result;
    }

    @GetMapping("/test/log")
    public String testLog()
    {
        String result = monitorService.testLog(1);
        return result;
    }
}
