package com.course.movie.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.course.movie.model.Content;




@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {

	

	List<Content> findAll();

	

	
	  
}
