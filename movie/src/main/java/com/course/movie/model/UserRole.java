package com.course.movie.model;

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
public class UserRole {

	  @EmbeddedId
	  private  UserRoleKey id;

	    @ManyToOne
	    @MapsId("RoleID")
	    @JsonIgnore
	    @JoinColumn(name = "RoleID")
	    private  Role role;

	    @ManyToOne
	    @MapsId("UserID")
	    @JsonIgnore
	    @JoinColumn(name = "UserID")
	    private  User user;
   
    
   

}