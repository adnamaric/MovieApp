package com.course.movie.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.course.movie.dto.ContentDto;
import com.course.movie.model.Content;
import com.course.movie.model.ContentType;
import com.course.movie.model.Country;
import com.course.movie.model.Language;
import com.course.movie.repository.ContentRepository;
import com.course.movie.repository.ContentTypeRepository;
import com.course.movie.repository.CountryRepository;
import com.course.movie.repository.LanguageRepository;

@Service
public class ContentService {

	@Autowired
	ContentRepository contentRepository;
	@Autowired
	CountryRepository countryRepository;
	@Autowired
	LanguageRepository languageRepository;
	@Autowired
	ContentTypeRepository contentTypeRepository;
	
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
        
		List<Language> list= new ArrayList<Language>(); 
		list=this.languageRepository.findAll();
		//Boolean jePronadjen=false;
	    for(int i=0; i<list.size();i++) {
		Language trazeni = list.get(i);
	    if(trazeni.getLanguageID()==contentDto.getLanguageID()) {
	    	content.setLanguage(trazeni);
		 }
	       }
	    
		List<ContentType> lista2= new ArrayList<ContentType>(); 
		lista2=this.contentTypeRepository.findAll();
		//Boolean jePronadjen=false;
	    for(int i=0; i<lista2.size();i++) {
	    	ContentType trazeni = lista2.get(i);
	    if(trazeni.getContentTypeID()==contentDto.getContentTypeID()) {
	    	content.setContentType(trazeni);
		 }
	       }
	   
	    List<Country> lista3= new ArrayList<Country>(); 
	    lista3=this.countryRepository.findAll();
		//Boolean jePronadjen=false;
	    for(int i=0; i<lista3.size();i++) {
	    	Country trazeni = lista3.get(i);
	    if(trazeni.getCountryID()==contentDto.getCountryID()) {
	    	content.setCountry(trazeni);
		 }
	       }
		return content;
	}
}
