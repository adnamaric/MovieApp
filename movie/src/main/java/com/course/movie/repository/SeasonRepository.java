package com.course.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.Season;

@Repository
public interface SeasonRepository extends JpaRepository <Season, Integer>{

}
