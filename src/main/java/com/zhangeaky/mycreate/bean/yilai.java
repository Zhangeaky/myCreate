package com.zhangeaky.mycreate.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class yilai {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    void init() {
    }
}
