package com.course.movie.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;





@Entity
@Table(name = "MovieCast")
@Getter
@Setter
class MovieCast {

    @EmbeddedId
    MovieCastKey id;

    @ManyToOne
    @MapsId("ContentID")
    @JoinColumn(name = "ContentID")
    Content content;
    
    @ManyToOne
    @MapsId("MovieRoleID")
    @JoinColumn(name = "MovieRoleID")
    MovieRole movieRole;

    @ManyToOne
    @MapsId("MoviePeopleID")
    @JoinColumn(name = "MoviePeopleID")
    MoviePeople moviePeople;

    
    
    // standard constructors, getters, and setters
}