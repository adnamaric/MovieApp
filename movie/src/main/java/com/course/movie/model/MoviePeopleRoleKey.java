package com.course.movie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoviePeopleRoleKey implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "MovieRoleID", nullable=false)
    private int MovieRoleID;

    @Column(name = "MoviePeopleID", nullable=false)
    private int MoviePeopleID;

    // standard constructors, getters, and setters
    // hash code and equals implementation
}