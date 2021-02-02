package com.chongaizhen.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author chongaizhen
 * @date 2021-02-02
 */
@Service
public class MonitorFallbackService implements MonitorService {

    @Override
    public String testHeader(Integer id) {
        return "error";
    }

    @Override
    public String testHeaderAnnotation(Integer id, String token) {
        return "error";
    }

    @Override
    public String testLog(Integer id) {
        return "error";
    }
}
