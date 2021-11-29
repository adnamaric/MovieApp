package com.course.movie.repository;

import java.util.Collection;
//import java.util.List;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	  Collection<Student> findAllByOrderByStudentAgeAsc();
	
	  List<Student> findAll();

}
