package com.course.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.movie.model.Garage;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Integer> {

}
