package com.course.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.movie.model.Language;
import com.course.movie.repository.LanguageRepository;

@Service
public class LanguageService {

	@Autowired
	LanguageRepository languageRepository;


	public List<Language> getAll() {
		return languageRepository.findAll();
	}
 
	
	
}
