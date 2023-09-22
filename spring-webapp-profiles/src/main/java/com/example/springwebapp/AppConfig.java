package com.example.springwebapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class AppConfig {
	
	private String username;
	
	private String password;
	
	private String url;
	
	private String driverClassName;
	
	
	
	@Bean
	@Profile("prod")
	public String testProdDB() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
		System.out.println(driverClassName);			
		return "Connected to Prod";
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	@Bean
	@Profile("dev")
	public String testDevDB() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
		System.out.println(driverClassName);		
		return "Connected to dev";
	}
	
	
	@Bean
	@Profile("test")
	public String testTestDB() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
		System.out.println(driverClassName);			
		return "Connected to test";
	}
	
	@Bean
	@Profile("userenv")
	public String testUserEvnDB() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
		System.out.println(driverClassName);			
		return "Connected to userenv";
	}
	
	@Bean
	@Profile("preprod")
	public String testPreProdDB() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
		System.out.println(driverClassName);			
		return "Connected to preprod";
	}
}
