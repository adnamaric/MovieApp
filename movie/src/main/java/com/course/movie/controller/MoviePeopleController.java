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

import com.course.movie.dto.MoviePeopleDto;
import com.course.movie.model.MoviePeople;
import com.course.movie.repository.MoviePeopleRepository;
import com.course.movie.service.MoviePeopleService;

@RestController
@RequestMapping("/moviepeople")
public class MoviePeopleController {
	@Autowired
	MoviePeopleService moviePeopleService;
	@Autowired
	MoviePeopleRepository moviePeopleRepository;
	
	 @GetMapping("/all")
	  public List<MoviePeople> findAll(){
	        return moviePeopleRepository.findAll();
	   }
	
	 @PostMapping("/insert")
		public MoviePeople insert(@RequestBody MoviePeopleDto movieRoleDto) throws NotFoundException {
			return moviePeopleService.insert(movieRoleDto);
		}

		@PutMapping("/update")
		public MoviePeople update(@RequestBody MoviePeople mp) throws NotFoundException {
			return moviePeopleService.update(mp);
		}

		@DeleteMapping("/delete")
		public void delete(@RequestParam int id) throws NotFoundException {
			moviePeopleService.delete(id);
		}
}
