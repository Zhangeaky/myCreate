package com.zhangeaky.mycreate.controller.spring;

import com.zhangeaky.mycreate.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class SpringController {

    private String doBiz(String arg) {
        return arg + "-" + "arg has been processed by controller";
    }

    @Autowired
   // @Qualifier("weChantService")
    CommonService service;

    @PostConstruct
    public void init() {
        service.doSth();
    }

    @RequestMapping("spring")
    public String spring() {
        return "a";
    }

    @RequestMapping("spring/aop")
    public String aop(String arg) {

        String result = doBiz(arg);

        return result;

    }


}
