package com.hackathon.imageanalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ImageAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageAnalysisApplication.class, args);
	}

}
