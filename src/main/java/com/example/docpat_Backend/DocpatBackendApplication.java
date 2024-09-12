package com.example.docpat_Backend;

import com.example.docpat_Backend.serviceImpl.AuthenticationServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DocpatBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocpatBackendApplication.class, args);
	}
/**
	@Bean
	CommandLineRunner init(AuthenticationServiceImpl userService) {
		return args -> {
			userService.createUser("user@gmail.com", "password123");
		};
	}
**/
	}
