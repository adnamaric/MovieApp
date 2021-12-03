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
import com.course.movie.dto.ContentDto;
import com.course.movie.dto.ContentGenreDto;
import com.course.movie.dto.ReviewDto;
import com.course.movie.model.Content;
import com.course.movie.model.ContentGenre;
import com.course.movie.model.Review;
import com.course.movie.repository.ContentGenreRepository;
import com.course.movie.repository.ContentRepository;
import com.course.movie.service.ContentService;




@RestController
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	ContentService contentService;
	@Autowired
	ContentRepository contentRepository;
    @Autowired
    ContentGenreRepository contentGenreRepository;
	 @GetMapping("/test")
	  public String sayHello(){
	        return "It works";
	    }
	
	 @GetMapping("/all")
	  public List<Content> findAll(){
	        return contentRepository.findAll();
	    }
	 @PostMapping("/save")
		public Content save(@RequestBody ContentDto contentDto) throws NotFoundException {
			return contentService.save(contentDto);
		}

		@PutMapping("/update")
		public Content update(@RequestBody Content content) throws NotFoundException {
			return contentService.update(content);
		}

		@DeleteMapping("/delete")
		public void delete(@RequestParam int id) throws NotFoundException {
			contentService.delete(id);
		}
		@PostMapping("/addGenre")
		public ContentGenre addGenre (@RequestBody ContentGenreDto contentGenreDto) throws NotFoundException {
			return contentService.addGenre(contentGenreDto);
		}
		@PostMapping("/addReview")
		public Review addReview (@RequestBody ReviewDto reviewDto) throws NotFoundException {
			return contentService.addReview(reviewDto);
		}
		

}
