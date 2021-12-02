package com.course.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.ContentComment;

@Repository
public interface ContentCommentRepository extends JpaRepository<ContentComment, Integer>{

	List<ContentComment> findAll();
}
