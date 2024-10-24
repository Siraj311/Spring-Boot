package com.example.demo.sprng_data_jpa_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SprngDataJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprngDataJpaDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student Maria = new Student(
					"Maria",
					"Jones",
					"maria.jones@gmail.com",
					21
			);

			studentRepository.save(Maria);
		};
	}
}
