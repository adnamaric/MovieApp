package com.course.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Fakultet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facultyID ;

    @Column(nullable = false)
    private String facultyName;

    @Column( nullable = false)
    private String numberOfStudents;
    
}