package com.zhangeaky.mycreate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BaseController {

    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();


        jdbcTemplate.execute("");


    }
}
