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

public class ContentGenreKey implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ContentID")
  private int  ContentID;

    @Column(name = "GenreId")
   private int GenreId;
    
   
    // standard constructors, getters, and setters
    // hash code and equals implementation
}