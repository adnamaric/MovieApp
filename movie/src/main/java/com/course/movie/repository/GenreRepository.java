package com.course.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
