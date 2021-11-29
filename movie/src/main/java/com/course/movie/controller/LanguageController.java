package com.course.movie.controller;


import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.movie.model.Language;
import com.course.movie.repository.LanguageRepository;




@RestController
@RequestMapping("/language")
public class LanguageController {
	
	@Autowired
	LanguageRepository languageRepository;
	
	 @GetMapping("/test")
	  public String sayHello(){
	        return "It works";
	    }
	
	 @GetMapping("/all")
	  public List<Language> findAll(){
	        return languageRepository.findAll();
	   }
	
}
