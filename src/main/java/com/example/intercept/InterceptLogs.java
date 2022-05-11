package com.example.intercept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class InterceptLogs {

	public static void main(String[] args) {

		SpringApplication.run(InterceptLogs.class, args);
	}


}
