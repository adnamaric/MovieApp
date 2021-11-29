package com.course.movie.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import javax.persistence.Table;

import lombok.Getter;

//import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SerieCast")
 class SerieCast {

	   @EmbeddedId
	   SerieCastKey id;

	    @ManyToOne
	    @MapsId("SeasonId")
	    @JoinColumn(name = "SeasonId")
	    Season season;
	    
	    @ManyToOne
	    @MapsId("MovieRoleID")
	    @JoinColumn(name = "MovieRoleID")
	    MovieRole movieRole;

	    @ManyToOne
	    @MapsId("MoviePeopleID")
	    @JoinColumn(name = "MoviePeopleID")
	    MoviePeople moviePeople;

   
}