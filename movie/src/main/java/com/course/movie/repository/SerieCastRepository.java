package com.course.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.SerieCast;
import com.course.movie.model.SerieCastKey;

@Repository
public interface SerieCastRepository extends JpaRepository <SerieCast, SerieCastKey>{

}
