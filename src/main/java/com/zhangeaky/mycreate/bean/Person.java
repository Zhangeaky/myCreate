package com.zhangeaky.mycreate.bean;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Person {

    Car bmw;

    public Car getBmw() {
        return bmw;
    }

    public void setBmw(Car bmw) {
        this.bmw = bmw;
    }
}
