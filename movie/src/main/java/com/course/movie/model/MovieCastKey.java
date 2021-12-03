package com.course.movie.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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
public class MovieCastKey implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "MovieRoleID")
    private int MovieRoleID;

    @Column(name = "MoviePeopleID")
    private int MoviePeopleID;
    
    @Column(name = "ContentID")
    private int ContentID;
    // standard constructors, getters, and setters
    // hash code and equals implementation
}