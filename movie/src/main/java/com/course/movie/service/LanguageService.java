package com.course.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.course.movie.dto.LanguageDto;
import com.course.movie.model.Language;
import com.course.movie.repository.LanguageRepository;

@Service
public class LanguageService {

	@Autowired
	LanguageRepository languageRepository;


	
	public Language insert(LanguageDto languageDto) {
		return languageRepository.save(createLanguageFromDto(languageDto));
	}

	public Optional<Language> findById(int id) throws NotFoundException {
		return languageRepository.findById(id);
		}

	public Language update(Language language)  {
		if (languageRepository.existsById(language.getLanguageID())) {
			return languageRepository.save(language);
		}
//		throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genre.getGenreId());
		else {
			return language;	
		}
	}
   
	public void delete(int languageID) throws NotFoundException {
		if (languageRepository.existsById(languageID)) {
			languageRepository.deleteById(languageID);
		} else {
//			throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genreId);
			
		}
	}

	public List<Language> getAll() {
		return languageRepository.findAll();
	}

	private Language createLanguageFromDto(LanguageDto languageDto) {
		Language language = new Language();
		language.setLanguageName(languageDto.getName());
		language.setCode(languageDto.getCode());
		

		return language;
	}
	
	
}
