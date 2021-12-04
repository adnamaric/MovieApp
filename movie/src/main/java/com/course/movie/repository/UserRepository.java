package com.course.movie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

	User getByUserName(String userName);
	User getByEmail(String email);
	List<User> findAll();
	//User getByuserName(String userName);

}
