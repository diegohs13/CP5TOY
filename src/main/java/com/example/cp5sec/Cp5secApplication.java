package com.example.cp5sec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cp5secApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cp5secApplication.class, args);
		System.out.println("SpringBoot rodando na porta 8080");
	}

}
