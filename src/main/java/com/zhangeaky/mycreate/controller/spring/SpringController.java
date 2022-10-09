package com.zhangeaky.mycreate.controller.spring;

import com.zhangeaky.mycreate.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class SpringController {

    @Autowired
   // @Qualifier("weChantService")
    CommonService service;

    @PostConstruct
    public void init() {
        service.doSth();
    }

    @RequestMapping()
    public String spring() {
        return "a";
    }
}
