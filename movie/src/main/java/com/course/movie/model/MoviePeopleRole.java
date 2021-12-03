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
public class MoviePeopleRole {

    @EmbeddedId
    MoviePeopleRoleKey id;

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

    
    
    // standard constructors, getters, and setters
}