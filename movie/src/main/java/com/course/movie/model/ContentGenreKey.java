package com.course.movie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class ContentGenreKey implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ContentID")
    Long ContentID;

    @Column(name = "GenreId")
    Long GenreId;
    
   
    // standard constructors, getters, and setters
    // hash code and equals implementation
}