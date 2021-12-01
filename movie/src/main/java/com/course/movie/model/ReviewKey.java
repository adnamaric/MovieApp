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
public class ReviewKey implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Column(name = "UserID", nullable=false)
    private int UserID;
    
    @Column(name = "ContentID", nullable=false)
    private int ContentID;
    // standard constructors, getters, and setters
    // hash code and equals implementation
}