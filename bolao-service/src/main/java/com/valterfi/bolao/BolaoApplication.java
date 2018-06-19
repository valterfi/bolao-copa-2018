package com.valterfi.bolao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.valterfi")
@EnableWebMvc
public class BolaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BolaoApplication.class, args);
	}
}
