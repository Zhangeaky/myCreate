package com.zhangeaky.mycreate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Semaphore;

@RestController
@RequestMapping("/try")
public class TryController {

    @Autowired
    Semaphore semaphore;

    @RequestMapping("entry.htm")
    public String test() {
        System.out.println("[log]" + Thread.currentThread().getName()
                + this.getClass().getSimpleName());

        try {
            Thread.sleep(600000);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {

        }

        return "Hello";
    }

    @RequestMapping("/hello")
    String hello() {
        return "hello";
    }
}
