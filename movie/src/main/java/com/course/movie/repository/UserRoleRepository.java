package com.course.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.UserRole;
import com.course.movie.model.UserRoleKey;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleKey>{

}
