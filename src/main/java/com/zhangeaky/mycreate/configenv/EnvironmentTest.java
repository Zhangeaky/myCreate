package com.zhangeaky.mycreate.configenv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class EnvironmentTest {

    @Autowired
    Environment environment;

    public String getValue() {
        return environment.getProperty("jdbc.url");
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EnvironmentTest.class, args);
        Binder binder = Binder.get(context.getEnvironment());
        BindResult<RedisProperties> bind = binder.bind("spring.yida.redis", Bindable.of(RedisProperties.class));
        RedisProperties redisProperties = bind.get();
        System.out.println(redisProperties.getPasswd());
    }


}
