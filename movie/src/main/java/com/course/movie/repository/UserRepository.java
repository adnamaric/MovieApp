package com.course.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

}
