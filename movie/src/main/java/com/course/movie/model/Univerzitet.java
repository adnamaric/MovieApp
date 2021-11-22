package com.course.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Univerzitet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int universityID ;

    @Column(nullable = false)
    private String universityName;

    
    
}