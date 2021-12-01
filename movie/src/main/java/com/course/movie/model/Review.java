package com.course.movie.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
@Entity
@Table
public class Review {

	  @EmbeddedId
	   ReviewKey id;

//	    @ManyToOne
//	    @MapsId("UserID")
//	    @JoinColumn(name = "UserID")
//	    User user;
//   
	    @ManyToOne
	    @MapsId("ContentID")
	    @JoinColumn(name = "ContentID")
	    Content content;

	    @Column(nullable = false)
	    private Integer rating;
    
	    @Column(nullable = false)
	    private Boolean favourite;

}