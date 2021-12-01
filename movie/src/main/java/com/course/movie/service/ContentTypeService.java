package com.course.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.course.movie.dto.ContentTypeDto;
import com.course.movie.model.ContentType;
import com.course.movie.repository.ContentTypeRepository;

@Service
public class ContentTypeService {
	
 @Autowired
 ContentTypeRepository contentTypeRepository;
 
 public ContentType save(ContentTypeDto contentTypeDto) {
		return contentTypeRepository.save(createContentTypeFromDto(contentTypeDto));
	}

	public Optional<ContentType> findById(int id) throws NotFoundException {
		return contentTypeRepository.findById(id);
		}

	public ContentType update(ContentType contentType)  {
		if (contentTypeRepository.existsById(contentType.getContentTypeID())) {
			return contentTypeRepository.save(contentType);
		}
//		throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genre.getGenreId());
		else {
			return contentType;	
		}
	}

	public void delete(int contentTypeId) throws NotFoundException {
		if (contentTypeRepository.existsById(contentTypeId)) {
			contentTypeRepository.deleteById(contentTypeId);
		} else {
//			throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genreId);
		}
	}

	public List<ContentType> getAll() {
		return contentTypeRepository.findAll();
	}

	private ContentType createContentTypeFromDto(ContentTypeDto contentTypeDto) {
		ContentType contentType = new ContentType();
		contentType.setName(contentTypeDto.getName());
	

		return contentType;
	}
}
