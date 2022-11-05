package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	
	//Select *from studen where email=? 
	//sentencia que se ejecuta con Jpa con solo colocarlo de esta manera
	Optional<Student>findStudentEmail(String email);
	
}
