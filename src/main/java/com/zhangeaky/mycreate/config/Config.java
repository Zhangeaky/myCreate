package com.zhangeaky.mycreate.config;

import java.util.stream.Stream;

public class Config {

    public static void main(String[] args) {

        String property = System.getProperty("user.dir");
        String property1 = System.getProperty("java.class.path");
        Stream.of(property1.split(":")).forEach(System.out::println);
        System.out.println(property);

    }
}
