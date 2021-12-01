package com.course.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.MovieRole;

@Repository
public interface MovieRoleRepository extends JpaRepository<MovieRole, Integer> {

	List<MovieRole> findAll();
}
