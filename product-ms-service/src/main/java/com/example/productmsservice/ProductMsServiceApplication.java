package com.example.productmsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.model")
@ComponentScan("com")
@EnableJpaRepositories("com.dao")
@EnableEurekaClient
public class ProductMsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMsServiceApplication.class, args);
	}

}
