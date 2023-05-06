package com.zhangeaky.mycreate.biz;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component("bizAspect")
public class BizAspect {



    @Pointcut("execution(private * com.zhangeaky.mycreate.controller.spring.SpringController.doBiz(..))")
    public void aspect(){}


    @AfterReturning("aspect()")
    public void logreturn(JoinPoint joinPoint) {

        System.out.println("AfterReturning advice");
        System.out.println(joinPoint.getArgs().getClass());
        Object[] args = joinPoint.getArgs();
        System.out.println(args[0]);

    }

}
