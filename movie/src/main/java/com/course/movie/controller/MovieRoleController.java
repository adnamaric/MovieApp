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
import com.course.movie.dto.MovieRoleDto;
import com.course.movie.model.MovieRole;
import com.course.movie.repository.MovieRoleRepository;
import com.course.movie.service.MovieRoleService;

@RestController
@RequestMapping("/movierole")
public class MovieRoleController {

	@Autowired
	MovieRoleService movieRoleService;
	@Autowired
	MovieRoleRepository movieRoleRepository;
	
	 @GetMapping("/all")
	  public List<MovieRole> findAll(){
	        return movieRoleRepository.findAll();
	   }
	
	 @PostMapping("/insert")
		public MovieRole insert(@RequestBody MovieRoleDto movieRoleDto) throws NotFoundException {
			return movieRoleService.insert(movieRoleDto);
		}

		@PutMapping("/update")
		public MovieRole update(@RequestBody MovieRole mr) throws NotFoundException {
			return movieRoleService.update(mr);
		}

		@DeleteMapping("/delete")
		public void delete(@RequestParam int id) throws NotFoundException {
			movieRoleService.delete(id);
		}
}
