package com.kgisl.studentCrudAngular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class StudentCrudAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCrudAngularApplication.class, args);
	}

}
