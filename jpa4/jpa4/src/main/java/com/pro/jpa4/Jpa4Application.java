package com.pro.jpa4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class Jpa4Application {

	public static void main(String[] args) {
		SpringApplication.run(Jpa4Application.class, args);
	}

}
