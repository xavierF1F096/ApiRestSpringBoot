package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table	
public class Student {
	@Id
      private Long id;
      private String name;
      private String email;
      private LocalDate dob;
      @Transient  	//ignora el mapeo de jpa
      private Integer age;
      
      
      public Student() {
      }


      public Long getId() {
            return id;
      }


      public void setId(Long id) {
            this.id = id;
      }


      public String getName() {
            return name;
      }


      public void setName(String name) {
            this.name = name;
      }


      public String getEmail() {
            return email;
      }


      public void setEmail(String email) {
            this.email = email;
      }


      public LocalDate getDob() {
            return dob;
      }


      public void setDob(LocalDate dob) {
            this.dob = dob;
      }


      public Integer getAge() {
            return Period.between(dob,LocalDate.now()).getYears();
      }


      public void setAge(Integer age) {
            this.age = age;
      }


      public Student(Long id, String name, String email, LocalDate dob) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.dob = dob;
            
      }


      public Student(String name, String email, LocalDate dob) {
            this.name = name;
            this.email = email;
            this.dob = dob;
            
      }

      
}
