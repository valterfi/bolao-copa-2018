package com.valterfi.bolao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.valterfi")
public class BolaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BolaoApplication.class, args);
	}
}
