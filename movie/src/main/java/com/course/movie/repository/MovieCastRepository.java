package com.course.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.MovieCast;
import com.course.movie.model.MovieCastKey;

@Repository
public interface MovieCastRepository extends JpaRepository <MovieCast, MovieCastKey> {

}
