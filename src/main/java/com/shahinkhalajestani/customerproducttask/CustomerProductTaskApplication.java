package com.shahinkhalajestani.customerproducttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@PropertySource("classpath:resultstatus.properties")
public class CustomerProductTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerProductTaskApplication.class, args);
	}

}
