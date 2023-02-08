package com.zhangeaky.mycreate.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("yida/api/register")
public class RegisterController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("register")
    public String register(@RequestParam String name,
                           @RequestParam String passwd,
                           @RequestParam String code) {

        jdbcTemplate.execute("insder");
        return "";
    }
}
