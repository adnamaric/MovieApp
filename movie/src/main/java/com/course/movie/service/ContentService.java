package com.course.movie.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.course.movie.dto.ContentDto;
import com.course.movie.model.Content;
import com.course.movie.repository.ContentRepository;

@Service
public class ContentService {

	@Autowired
	ContentRepository contentRepository;

	
	public Content save(ContentDto contentDto) {
		return contentRepository.save(createContentFromDto(contentDto));
	}

	public Optional<Content> findById(Integer id) throws NotFoundException {
		return contentRepository.findById(id);
		}

	public Content update(Content content)  {
		if (contentRepository.existsById(content.getContentID())) {
			return contentRepository.save(content);
		}
//		throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genre.getGenreId());
		else {
			return content;	
		}
	}
   
	public void delete(int contentId) throws NotFoundException {
		if (contentRepository.existsById(contentId)) {
			contentRepository.deleteById(contentId);
		} else {
//			throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genreId);
		}
	}

	public List<Content> getAll() {
		return contentRepository.findAll();
	}

	private Content createContentFromDto(ContentDto contentDto) {
		Content content = new Content();
		content.setTitle(contentDto.getTitle());
		content.setYear(contentDto.getYear());
		content.setDuration(contentDto.getDuration());

		return content;
	}
}
