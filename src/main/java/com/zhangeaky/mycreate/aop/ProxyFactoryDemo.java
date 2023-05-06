package com.zhangeaky.mycreate.aop;

import com.zhangeaky.mycreate.service.AlipayService;
import com.zhangeaky.mycreate.service.CommonService;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class ProxyFactoryDemo {

    public static void main(String[] args) {
        ProxyFactory  pf = new ProxyFactory();

        pf.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("before");
            }
        });

        pf.setTarget(new AlipayService());
        pf.setInterfaces(new Class[]{});
        CommonService proxy = (CommonService)pf.getProxy();
        proxy.pay();
    }
}
