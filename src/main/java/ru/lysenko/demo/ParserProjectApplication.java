package ru.lysenko.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("ru.lysenko.demo")
@SpringBootApplication
public class ParserProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParserProjectApplication.class, args);
	}

}
