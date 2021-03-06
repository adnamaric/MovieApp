package com.course.movie.controller;


import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.movie.dto.LanguageDto;
import com.course.movie.model.Language;
import com.course.movie.repository.LanguageRepository;
import com.course.movie.service.LanguageService;




@RestController
@RequestMapping("/language")
public class LanguageController {
	
	@Autowired
	LanguageRepository languageRepository;
	@Autowired
	LanguageService languageService;
	 @GetMapping("/test")
	  public String sayHello(){
	        return "It works";
	    }
	
	 @GetMapping("/all")
	  public List<Language> findAll(){
	        return languageRepository.findAll();
	   }
	
	 @PostMapping("/insert")
		public Language insert(@RequestBody LanguageDto languageDto) throws NotFoundException {
			return languageService.insert(languageDto);
		}

		@PutMapping("/update")
		public Language update(@RequestBody Language language) throws NotFoundException {
			return languageService.update(language);
		}

		@DeleteMapping("/delete")
		public void delete(@RequestParam int id) throws NotFoundException {
			languageService.delete(id);
		}
}
