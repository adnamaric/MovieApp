package com.course.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.movie.model.Country;


public interface CountryRepository  extends JpaRepository<Country, Integer> {
	List<Country> findAll();

}
