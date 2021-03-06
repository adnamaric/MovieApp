package com.course.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>  {
	List<Language> findAll();
}
