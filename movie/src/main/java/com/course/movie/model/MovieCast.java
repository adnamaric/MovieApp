package com.course.movie.model;

import java.sql.Date;
import java.util.List;

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
@Table(name = "MovieCast")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieCast {

    @EmbeddedId
   private MovieCastKey id;

    @ManyToOne
    @MapsId("ContentID")
    @JsonIgnore
    @JoinColumn(name = "ContentID")
    private Content content;
    
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
   
//    @ManyToOne
//    @MapsId("MoviePeopleRoleID")
//    @JoinColumn(name = "MoviePeopleRoleID")
//    private MoviePeopleRole moviePeopleRole;
    
    
    // standard constructors, getters, and setters
}