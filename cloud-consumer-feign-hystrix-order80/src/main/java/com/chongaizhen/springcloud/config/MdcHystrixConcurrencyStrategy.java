package com.chongaizhen.springcloud.config;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author chongaizhen
 * @date 2021-03-26
 */
public class MdcHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return new MdcAwareCallable(callable, MDC.getCopyOfContextMap(), RequestContextHolder.getRequestAttributes());
    }

    private class MdcAwareCallable<T> implements Callable<T> {

        private final Callable<T> delegate;

        private final Map<String, String> contextMap;

        private final RequestAttributes requestAttributes;

        public MdcAwareCallable(Callable<T> callable, Map<String, String> contextMap, RequestAttributes requestAttributes) {
            this.delegate = callable;
            this.contextMap = contextMap != null ? contextMap : new HashMap();
            this.requestAttributes = requestAttributes;
        }

        @Override
        public T call() throws Exception {
            try {
                MDC.setContextMap(contextMap);
                RequestContextHolder.setRequestAttributes(requestAttributes);
                return delegate.call();
            } finally {
                MDC.clear();
                RequestContextHolder.resetRequestAttributes();
            }
        }
    }
}