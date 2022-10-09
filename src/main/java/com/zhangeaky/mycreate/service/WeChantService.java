package com.zhangeaky.mycreate.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier
public class WeChantService implements CommonService{

    @Override
    public void doSth() {
        System.out.println("WeChant!");
    }
}
