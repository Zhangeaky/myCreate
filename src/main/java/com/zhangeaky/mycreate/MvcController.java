package com.zhangeaky.mycreate;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
public class MvcController {

    @PostConstruct
    void init() {
        System.out.println("fdfdfdfdfdfdfdfdfd");
    }

    @RequestMapping("/mvc")
    public void test(ModelMap map, @RequestParam String name) {
        System.out.println(name);

        map.put("name", name);

    }
}
