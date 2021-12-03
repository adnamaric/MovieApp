package com.course.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.course.movie.dto.ContentCommentDto;
import com.course.movie.model.Content;
import com.course.movie.model.ContentComment;
import com.course.movie.model.User;
import com.course.movie.repository.ContentCommentRepository;
import com.course.movie.repository.ContentRepository;
import com.course.movie.repository.UserRepository;

@Service
public class ContentCommentService {
	@Autowired
	ContentCommentRepository contentCommentRepository;
	@Autowired
	ContentRepository contentRepository;
	@Autowired
	UserRepository userRepository;
	
	public ContentComment save(ContentCommentDto contentDto) {
		return contentCommentRepository.save(createCommentFromDto(contentDto));
	}

	public Optional<ContentComment> findById(Integer id) throws NotFoundException {
		return contentCommentRepository.findById(id);
		}

	public ContentComment update(ContentComment contentComment)  {
		if (contentCommentRepository.existsById(contentComment.getCommentID())) {
			return contentCommentRepository.save(contentComment);
		}
//		throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genre.getGenreId());
		else {
			return contentComment;	
		}
	}
   
	public void delete(int contentId) throws NotFoundException {
		if (contentCommentRepository.existsById(contentId)) {
			contentCommentRepository.deleteById(contentId);
		} else {
//			throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genreId);
		}
	}

	public List<ContentComment> getAll() {
		return contentCommentRepository.findAll();
	}
	private ContentComment createCommentFromDto(ContentCommentDto commentDto) {
		ContentComment comment = new ContentComment();
		comment.setComment(commentDto.getComment());
	
        
		List<Content> list= new ArrayList<Content>(); 
		list=this.contentRepository.findAll();
		//Boolean jePronadjen=false;
	    for(int i=0; i<list.size();i++) {
		Content trazeni = list.get(i);
	    if(trazeni.getContentID()==commentDto.getContentID()) {
	    	comment.setContent(trazeni);
		 }
	       }
	    
		List<User> lista2= new ArrayList<User>(); 
		lista2=this.userRepository.findAll();
		//Boolean jePronadjen=false;
	    for(int i=0; i<lista2.size();i++) {
	    	User trazeni = lista2.get(i);
	    if(trazeni.getUserID()==commentDto.getUserID()) {
	    	comment.setUser(trazeni);
		 }
	       }
	   
	    
		return comment;
	}
}
