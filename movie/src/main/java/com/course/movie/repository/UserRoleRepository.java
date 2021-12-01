package com.course.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.movie.model.UserRole;
import com.course.movie.model.UserRoleKey;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleKey>{

}
