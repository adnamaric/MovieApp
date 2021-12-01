package com.course.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {

}
