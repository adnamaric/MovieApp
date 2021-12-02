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

import com.course.movie.dto.SeasonDto;
import com.course.movie.model.Season;
import com.course.movie.repository.SeasonRepository;
import com.course.movie.service.SeasonService;



@RestController
@RequestMapping("/season")
public class SeasonController {

	@Autowired
	SeasonService seasonService;
	@Autowired
	SeasonRepository seasonRepository;

	 @GetMapping("/test")
	  public String sayHello(){
	        return "It works";
	    }
	
	 @GetMapping("/all")
	  public List<Season> findAll(){
	        return seasonRepository.findAll();
	    }
	 @PostMapping("/save")
		public Season save(@RequestBody SeasonDto seasonDto) throws NotFoundException {
			return seasonService.save(seasonDto);
		}

		@PutMapping("/update")
		public Season update(@RequestBody Season content) throws NotFoundException {
			return seasonService.update(content);
		}

		@DeleteMapping("/delete")
		public void delete(@RequestParam int id) throws NotFoundException {
			seasonService.delete(id);
		}
}
