package com.bootcamp.springwebflux.msvcclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsvcClientApplication{

	public static void main(String[] args) {
		SpringApplication.run(MsvcClientApplication.class, args);
	}

}
