package com.example.springwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//Initializes the app
@SpringBootApplication
@ComponentScan("com")
public class SpringWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebappApplication.class, args);
	}

}
