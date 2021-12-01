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
import com.course.movie.dto.ContentTypeDto;
import com.course.movie.model.ContentType;
import com.course.movie.repository.ContentTypeRepository;
import com.course.movie.service.ContentTypeService;




@RestController
@RequestMapping("/type")
public class ContentTypeController {
	
	@Autowired
	ContentTypeService contentTypeService;
	@Autowired
	ContentTypeRepository contentTypeRepository;
	 @GetMapping("/test")
	  public String sayHello(){
	        return "It works";
	    }
	
	 @GetMapping("/all")
	  public List<ContentType> findAll(){
	        return contentTypeRepository.findAll();
	    }
	 @PostMapping("/insert")
		public ContentType save(@RequestBody ContentTypeDto contentTypeDto) throws NotFoundException {
			return contentTypeService.save(contentTypeDto);
		}

		@PutMapping("/update")
		public ContentType update(@RequestBody ContentType contentType) throws NotFoundException {
			return contentTypeService.update(contentType);
		}

		@DeleteMapping("/delete")
		public void delete(@RequestParam int id) throws NotFoundException {
			contentTypeService.delete(id);
		}

}
