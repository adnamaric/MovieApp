package com.course.movie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class MoviePeopleRoleKey implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "MovieRoleID")
    Long MovieRoleID;

    @Column(name = "MoviePeopleID")
    Long MoviePeopleID;

    // standard constructors, getters, and setters
    // hash code and equals implementation
}