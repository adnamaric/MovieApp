package com.course.movie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class StudentFacultyKey implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "studentId")
    Long studentId;

    @Column(name = "facultyId")
    Long facultyId;

    // standard constructors, getters, and setters
    // hash code and equals implementation
}