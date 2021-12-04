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

//import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "SerieCast")
 public class SerieCast {

	   @EmbeddedId
	 private SerieCastKey id;

	    @ManyToOne
	    @MapsId("SeasonId")
	    @JsonIgnore
	    @JoinColumn(name = "SeasonId")
	    private  Season season;
	    
	    @ManyToOne
	    @MapsId("MovieRoleID")
	    @JsonIgnore
	    @JoinColumn(name = "MovieRoleID")
	    private MovieRole movieRole;

	    @ManyToOne
	    @MapsId("MoviePeopleID")
	    @JsonIgnore
	    @JoinColumn(name = "MoviePeopleID")
	    private MoviePeople moviePeople;

   
}