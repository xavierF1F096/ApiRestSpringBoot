package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
	  return args ->{
		 Student maria= new Student(
				  1L,
				  "Maria",
				  "maria1231@gmail.com",
				  LocalDate.of(2000, Month.AUGUST, 2)
				 
				  );
		 Student roberto= new Student(
				  2L,
				  "roberto",
				  "toberto12@gmail.com",
				  LocalDate.of(2001, Month.APRIL, 8)
				  
				  );
		 repository.saveAll(List.of(maria,roberto));
	  }; 
  }
}
