package com.course.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.ContentType;

@Repository
public interface ContentTypeRepository extends JpaRepository <ContentType, Integer>{
	List<ContentType> findAll();
}
