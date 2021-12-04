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
@NoArgsConstructor
@AllArgsConstructor
public class SerieCastKey implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "SeasonId")
    private int SeasonId;

    @Column(name = "MovieRoleID")
    private int MovieRoleID;
    
    @Column(name = "MoviePeopleID")
    private int MoviePeopleID;
    // standard constructors, getters, and setters
    // hash code and equals implementation
}