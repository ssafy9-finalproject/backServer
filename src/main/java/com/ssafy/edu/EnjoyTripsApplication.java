package com.ssafy.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages= {"com.ssafy"})
public class EnjoyTripsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnjoyTripsApplication.class, args);
	}

}
