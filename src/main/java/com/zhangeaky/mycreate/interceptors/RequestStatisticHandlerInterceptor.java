package com.zhangeaky.mycreate.interceptors;

import com.zhangeaky.mycreate.ServiceMonitor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestStatisticHandlerInterceptor implements HandlerInterceptor, InitializingBean {

    @Autowired
    ServiceMonitor serviceMonitor;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        //serviceMonitor.requestCounterMap.putIfAbsent()
        serviceMonitor.requestCounterMap.putIfAbsent("ALL", 1L);
        Long all = serviceMonitor.requestCounterMap.get("ALL");
        serviceMonitor.requestCounterMap.put("ALL", ++all);
        System.out.println("" + serviceMonitor.requestCounterMap.get("ALL"));

        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[log]" + " " + this.getClass().getCanonicalName());
    }
}
