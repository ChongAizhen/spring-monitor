package com.chongaizhen.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author chongaizhen
 * @date 2021-03-26
 */
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    //线程ID常量
    private static final String THREAD_ID = "THREAD_ID";

    /**
     * controller方法前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.debug("preHandle running ...");
        //随机生成UUID
        String threadId = UUID.randomUUID().toString().trim().replaceAll("-", "");
        //添加到MDC
        MDC.put(THREAD_ID, threadId);

        //永远返回true
        return true;
    }

    /**
     * preHandle方法返回true之后
     * 在controller方法处理完之后调用
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //清空MDC的THREAD_ID
        MDC.remove(THREAD_ID);
    }

    /**
     * preHandle方法返回true之后
     * 在DispatcherServlet进行视图的渲染之后调用
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
