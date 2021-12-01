package com.course.movie.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
@Entity
@Table
public class UserRole {

	  @EmbeddedId
	   UserRoleKey id;

	    @ManyToOne
	    @MapsId("RoleID")
	    @JoinColumn(name = "RoleID")
	    Role role;

	    @ManyToOne
	    @MapsId("UserID")
	    @JoinColumn(name = "UserID")
        User user;
   
    
   

}