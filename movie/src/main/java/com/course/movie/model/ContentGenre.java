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
@Table(name = "ContentGenre")
@Getter
@Setter
class ContentGenre {

    @EmbeddedId
    ContentGenreKey id;

    @ManyToOne
    @MapsId("ContentID")
    @JoinColumn(name = "ContentID")
    Content content;

    @ManyToOne
    @MapsId("GenreId")
    @JoinColumn(name = "GenreId")
    Genre genre;

    
    
    // standard constructors, getters, and setters
}