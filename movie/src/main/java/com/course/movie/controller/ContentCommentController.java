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

import com.course.movie.dto.ContentCommentDto;
import com.course.movie.model.ContentComment;
import com.course.movie.repository.ContentCommentRepository;
import com.course.movie.service.ContentCommentService;

@RestController
@RequestMapping("/contentcomment")
public class ContentCommentController {
	@Autowired
	ContentCommentService commentService;
	@Autowired
	ContentCommentRepository commentRepository;
	 @GetMapping("/test")
	  public String sayHello(){
	        return "It works";
	    }
	
	 @GetMapping("/all")
	  public List<ContentComment> findAll(){
	        return commentRepository.findAll();
	    }
	 @PostMapping("/save")
		public ContentComment save(@RequestBody ContentCommentDto contentDto) throws NotFoundException {
			return commentService.save(contentDto);
		}

		@PutMapping("/update")
		public ContentComment update(@RequestBody ContentComment content) throws NotFoundException {
			return commentService.update(content);
		}

		@DeleteMapping("/delete")
		public void delete(@RequestParam int id) throws NotFoundException {
			commentService.delete(id);
		}
}
