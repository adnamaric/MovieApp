package com.course.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.movie.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
