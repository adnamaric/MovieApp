package com.course.movie.controller;

import java.util.Collection;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.movie.model.Student;
import com.course.movie.repository.StudentRepository;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	 @GetMapping("/test")
	  public String sayHello(){
	        return "It works";
	    }
	 
	 @GetMapping("/byAge")
	  public Collection<Student> findStudents(){
	        return studentRepository.findAllByOrderByStudentAgeAsc();
	    }
	
}
