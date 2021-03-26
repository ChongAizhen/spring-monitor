package com.chongaizhen.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private HttpServletRequest servletRequest;

    @GetMapping("/test/header")
    public String testHeader(@RequestParam("id") Integer id, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        if (id > 10) {
            return "true";
        }
        return "false";
    }

    @GetMapping("/test/header/annotation")
    public String testHeaderAnnotation(@RequestParam("id") Integer id, HttpServletRequest servletRequest) {
        String token = servletRequest.getHeader("token");
        if (id > 10) {
            return "true";
        }
        return "false";
    }

    @GetMapping("/test/log")
    public String testLog(@RequestParam("id") Integer id) {
        log.info("server测试traceId");
        if (id > 10) {
            return "true";
        }
        return "false";
    }
}
