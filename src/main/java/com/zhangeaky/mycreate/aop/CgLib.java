package com.zhangeaky.mycreate.aop;

import com.zhangeaky.mycreate.service.AlipayService;
import com.zhangeaky.mycreate.service.CommonService;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

public class CgLib {

    public static void main(String[] args) {
        AlipayService service = new AlipayService();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AlipayService.class);
        enhancer.setCallbacks(new Callback[]{new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("被代理了" + o.getClass());
                methodProxy.invoke(service, objects);
                //methodProxy.invokeSuper(o, objects);
                System.out.println("要返回 null 了");
                return null;
            }
        }, NoOp.INSTANCE});
        CommonService proxyCommonService = (CommonService)enhancer.create();
        proxyCommonService.doSth();
        proxyCommonService.pay();
    }
}
