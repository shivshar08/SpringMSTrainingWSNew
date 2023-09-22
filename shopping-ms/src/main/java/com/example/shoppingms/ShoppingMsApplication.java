package com.example.shoppingms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com.model")
@EnableJpaRepositories("com.dao")
public class ShoppingMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingMsApplication.class, args);
	}

	@Bean("webClient")
	public WebClient.Builder getWebClient(){
		return WebClient.builder();
	}
}
