package com.course.movie.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;





@Entity
@Table(name = "StudentFaculty")
@Getter
@Setter
class StudentFaculty {

    @EmbeddedId
    StudentFacultyKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentId")
    Student student;

    @ManyToOne
    @MapsId("facultyId")
    @JoinColumn(name = "facultyId")
    Faculty faculty;

    int rating;
    
    String descriptionOfSuccess;
    
    // standard constructors, getters, and setters
}