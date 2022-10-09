package com.zhangeaky.mycreate.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailService implements CommonService{

    @Override
    public void doSth() {
        System.out.println("Email");
    }
}
