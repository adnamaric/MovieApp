package com.course.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(nullable = false)
    private String studentName;

    @Column( nullable = false)
    private int studentAge;
    
    @ManyToOne
    @JoinColumn(name = "fakultetID")
    private Fakultet fakultet;
}
