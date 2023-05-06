package com.zhangeaky.mycreate.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@EnableAutoConfiguration (exclude = DataSourceAutoConfiguration.class)
@ComponentScan
public class Test {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Test.class);
        System.out.println("application run ...");
        System.out.println(context.getBean(YidaConfig.class));
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("person.name");
        System.out.println("person " + property);



    }
}
