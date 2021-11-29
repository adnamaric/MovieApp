package com.course.movie.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.movie.model.Content;
import com.course.movie.repository.ContentRepository;




@RestController
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	ContentRepository contentRepository;
	
	 @GetMapping("/test")
	  public String sayHello(){
	        return "It works";
	    }
	
	 @GetMapping("/all")
	  public List<Content> findAll(){
	        return contentRepository.findAll();
	    }
	
}
