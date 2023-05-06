package com.zhangeaky.mycreate;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.ImportResource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement( mode = AdviceMode.ASPECTJ)
@ImportResource("classpath*:/META-INF/spring/*.xml")
public class SpringBootApplicationBootStrap {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =
				SpringApplication.run(SpringBootApplicationBootStrap.class, args);
	}

}
