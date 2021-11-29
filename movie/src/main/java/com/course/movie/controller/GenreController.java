package com.course.movie.controller;

import java.util.List;
import java.util.Optional;

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

import com.course.movie.dto.GenreDto;
import com.course.movie.model.Genre;
import com.course.movie.service.GenreService;

@RestController
@RequestMapping("/genre")
public class GenreController {

	@Autowired
	GenreService genreService;

	@GetMapping
	public Optional<Genre> findById(@RequestParam int id) throws NotFoundException {
		return genreService.findById(id);
	}
	
	@PostMapping("/save")
	public Genre save(@RequestBody GenreDto genreDto) throws NotFoundException {
		return genreService.save(genreDto);
	}

	@PutMapping("/update")
	public Genre update(@RequestBody Genre genre) throws NotFoundException {
		return genreService.update(genre);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) throws NotFoundException {
		genreService.delete(id);
	}

	@GetMapping("/all")
	public List<Genre> getAll(){
		return genreService.getAll();
	}
}
