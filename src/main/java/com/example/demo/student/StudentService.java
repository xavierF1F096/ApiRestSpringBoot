package com.example.demo.student;



import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
         private final StudentRepository studentRepository;
         @Autowired
         public StudentService(StudentRepository studentRepository) {
			this.studentRepository=studentRepository;
         }
         
       public List<Student> getStudents(){
    	   return studentRepository.findAll();
    			  
       }//getStudents

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional=studentRepository.findStudentEmail(student.getEmail());
		if(studentOptional.isPresent()) { //valida si no ay error,true o false
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
		System.out.println(student);
		
	}

	public void deleteStudent(Long studentId) {
		boolean exists=studentRepository.existsById(studentId);
		if(!exists) {
			throw new IllegalStateException("student id:"+studentId+"does not exists");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {

		Student student=studentRepository.findById(studentId)
				.orElseThrow(() -> new IllegalStateException("student id:"+studentId+"does not exists"));
				
				if(name !=null && name.length()>0 && !Objects.equals(student.getName(), name)) {
					student.setName(name);
				}
				if(email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)) {
					Optional<Student> studentOptional =studentRepository.findStudentEmail(email);
					if(studentOptional.isPresent()) {
						throw new IllegalStateException("email taken");
					}
					student.setEmail(email);
				}
		
	}

	
       
       
}
