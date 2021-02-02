package com.chongaizhen.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chongaizhen
 * @date 2021-01-29
 */
@Component
@FeignClient(value = "cloud-payment-service" ,fallback = MonitorFallbackService.class)
public interface MonitorService {

    @GetMapping("/test/header")
    String testHeader(@RequestParam("id") Integer id);

    @GetMapping("/test/header/annotation")
    String testHeaderAnnotation(@RequestParam("id") Integer id, @RequestHeader("token") String token);

    @GetMapping("/test/log")
    String testLog(@RequestParam("id") Integer id);

}
