package com.example.springmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class SpringMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMqApplication.class, args);
	}

}
