package com.course.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.movie.model.User;

public interface UserRepository extends JpaRepository <User, Integer> {

}
