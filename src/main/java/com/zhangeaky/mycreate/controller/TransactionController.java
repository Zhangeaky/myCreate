package com.zhangeaky.mycreate.controller;


import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@RestController
public class TransactionController {

    @RequestMapping
    String tt() throws Exception{

        JdbcTransactionManager transactionManager = new JdbcTransactionManager();
        Connection connection = transactionManager.getDataSource().getConnection();

        return "";
    }
}
