package com.zhangeaky.mycreate.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class YidaBeanPostProcessor implements BeanPostProcessor {

    private int a = 0;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        a++;
        System.out.println("beanName: " + beanName + "yida: " + a + bean);
        return bean;
    }
}
