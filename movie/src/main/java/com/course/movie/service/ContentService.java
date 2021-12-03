package com.course.movie.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.course.movie.dto.ContentDto;
import com.course.movie.dto.ContentGenreDto;
import com.course.movie.model.Content;
import com.course.movie.model.ContentGenre;
import com.course.movie.model.ContentGenreKey;
import com.course.movie.model.ContentType;
import com.course.movie.model.Country;
import com.course.movie.model.Genre;
import com.course.movie.model.Language;
import com.course.movie.repository.ContentGenreRepository;
import com.course.movie.repository.ContentRepository;
import com.course.movie.repository.ContentTypeRepository;
import com.course.movie.repository.CountryRepository;
import com.course.movie.repository.GenreRepository;
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
	@Autowired
	ContentGenreRepository contentGenreRepository;
	@Autowired
	GenreRepository genreRepository;

	
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
    private ContentGenre createContentGenreFromContent(ContentGenreDto contentGenreDto) {
       ContentGenre novi= new ContentGenre();
       Genre genre=new Genre();
       Content cont=new Content();
       List<Content> list= new ArrayList<Content>(); 
    	list=this.contentRepository.findAll();
    	 for(int i=0; i<list.size();i++) {
    			Content trazeni = list.get(i);
    		    if(trazeni.getContentID()==contentGenreDto.getContentID()) {
    		    	cont.setContentID(trazeni.getContentID());
    		    	cont.setContentType(trazeni.getContentType());
    		    	cont.setContentGenre(trazeni.getContentGenre());
    		    	cont.setCountry(trazeni.getCountry());
    		    	cont.setDuration(trazeni.getDuration());
    		    	cont.setTitle(trazeni.getTitle());
    		    	cont.setYear(trazeni.getYear());
    			 }
    		       }
    	 List<Genre> list1= new ArrayList<Genre>(); 
     	list1=this.genreRepository.findAll();
     	 for(int i=0; i<list1.size();i++) {
     		 Genre trazeni = list1.get(i);
     		    if(trazeni.getGenreId()==contentGenreDto.getGenreId()) {
     		    	genre.setGenreId(trazeni.getGenreId());
     		    	genre.setName(trazeni.getName());
     			 }
     		       }
     	
     	 
     	 ContentGenreKey n=new ContentGenreKey(contentGenreDto.getContentID(),contentGenreDto.getGenreId());
          
     	 contentGenreRepository.save(new ContentGenre(n,cont,genre));
     	 novi.setContent(cont);
     	 novi.setGenre(genre);
     	 novi.setId(n);
     	 return novi;
        // provjerit u  content genre role key da ne postoji ista kombinacija kljuceva
//     	 List<ContentGenreKey> contentGenreKey =new ArrayList<ContentGenreKey>();
//     	contentGenreKey=this.contentGenreKeyRepository.findAll();
//     	Boolean postoji=false;
//     	for(int i=0; i<list1.size();i++) {
//     		ContentGenreKey pretrazi= contentGenreKey.get(i);
//     		if(pretrazi.getContentID()==contentGenreDto.getContentID() && pretrazi.getGenreId()== contentGenreDto.getGenreID())
//     			postoji=true;
//     		
//            }
//     		if(!postoji) 
//     		{
//     			ContentGenreKey novakombinacija=new ContentGenreKey();
//     			novakombinacija.setContentID(contentGenreDto.getContentID());
//     			novakombinacija.setGenreId(contentGenreDto.getGenreID());
//     			this.contentGenreKeyRepository.save(novakombinacija);
//     			return novi;
//     		}
//     		else
//     			return null;
//     			
     			
     		
     		
     		
    }
//	
	public ContentGenre addGenre(ContentGenreDto contentGenreDto) {
	       
		return contentGenreRepository.save(createContentGenreFromContent(contentGenreDto));
	}
}
