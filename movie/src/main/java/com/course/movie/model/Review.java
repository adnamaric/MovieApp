package com.course.movie.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

	   @EmbeddedId
	   ReviewKey id;

	    @ManyToOne
	    @MapsId("UserID")
	    @JsonIgnore
	    @JoinColumn(name = "UserID")
	    private User user;
   
	    @ManyToOne
	    @MapsId("ContentID")
	    @JsonIgnore
	    @JoinColumn(name = "ContentID")
	    private Content content;

	    @Column(nullable = false)
	    private Integer rating;
    
	    @Column(nullable = false)
	    private Boolean favourite;


}