package com.course.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.MoviePeople;

@Repository
public interface MoviePeopleRepository extends JpaRepository <MoviePeople, Integer>{

	List<MoviePeople> findAll();
}
