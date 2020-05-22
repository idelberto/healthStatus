package com.healthStatus;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.healthStatus.factory.ModelMapperFactory;

@SpringBootApplication
public class HealthStatusApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthStatusApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapperFactory().getModelMapper();
	}

}
