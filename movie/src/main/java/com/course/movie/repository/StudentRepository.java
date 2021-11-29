package com.course.movie.repository;

import java.util.Collection;
//import java.util.List;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.movie.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	  Collection<Student> findAllByOrderByStudentAgeAsc();
	
	  List<Student> findAll();

}
