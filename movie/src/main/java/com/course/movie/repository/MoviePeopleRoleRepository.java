package com.course.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.MoviePeopleRole;
import com.course.movie.model.MoviePeopleRoleKey;

@Repository
public interface MoviePeopleRoleRepository extends JpaRepository <MoviePeopleRole, MoviePeopleRoleKey> {
	List<MoviePeopleRole> findAll();

	//MoviePeopleRole save(MoviePeopleRole addRoleToPeople);
}
