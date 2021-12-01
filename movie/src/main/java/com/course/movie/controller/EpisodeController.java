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

import com.course.movie.dto.EpisodeDto;
import com.course.movie.model.Episode;
import com.course.movie.service.EpisodeService;

@RestController
@RequestMapping("/episode")

public class EpisodeController {

	@Autowired
	EpisodeService episodeService;

	@GetMapping
	public Optional<Episode> findById(@RequestParam int id) throws NotFoundException {
		return episodeService.findById(id);
	}
	
	@PostMapping("/save")
	public Episode save(@RequestBody EpisodeDto episodeDto) throws NotFoundException {
		return episodeService.save(episodeDto);
	}

	@PutMapping("/update")
	public Episode update(@RequestBody Episode genre) throws NotFoundException {
		return episodeService.update(genre);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) throws NotFoundException {
		episodeService.delete(id);
	}

	@GetMapping("/all")
	public List<Episode> getAll(){
		return episodeService.getAll();
	}
}
