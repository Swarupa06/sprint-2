package com.spring.ovs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.spring.ovs.repository")

@SpringBootApplication
public class Application {
	
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
     
}

