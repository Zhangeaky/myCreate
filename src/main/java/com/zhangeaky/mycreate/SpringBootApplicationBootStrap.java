package com.zhangeaky.mycreate;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@ImportResource("classpath:/META-INF/spring/moniter-bean.xml")
public class SpringBootApplicationBootStrap {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationBootStrap.class, args);
	}

}
