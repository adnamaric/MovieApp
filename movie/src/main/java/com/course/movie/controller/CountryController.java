package com.course.movie.controller;


import java.util.List;

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

import com.course.movie.dto.CountryDto;
import com.course.movie.model.Country;
import com.course.movie.repository.CountryRepository;
import com.course.movie.service.CountryService;




@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	@Autowired
	CountryRepository contentRepository;
	 @GetMapping("/test")
	  public String sayHello(){
	        return "It works";
	    }
	
	 @GetMapping("/all")
	  public List<Country> findAll(){
	        return contentRepository.findAll();
	    }
	 @PostMapping("/save")
		public Country save(@RequestBody CountryDto countryDto) throws NotFoundException {
			return countryService.save(countryDto);
		}

		@PutMapping("/update")
		public Country update(@RequestBody Country country) throws NotFoundException {
			return countryService.update(country);
		}

		@DeleteMapping("/delete")
		public void delete(@RequestParam int id) throws NotFoundException {
			countryService.delete(id);
		}

}