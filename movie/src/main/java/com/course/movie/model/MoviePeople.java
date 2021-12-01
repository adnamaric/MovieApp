package com.course.movie.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class MoviePeople {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MoviePeopleID ;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = true)
    private Date birthDate;
    
    @Column(nullable = false)
    private char gender;

}