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
@Table(name = "ContentGenre")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
 public class ContentGenre {

    @EmbeddedId
    @Column(name = "content_genre_id", nullable = false)
    private ContentGenreKey id;

    @ManyToOne
    @MapsId("ContentID")
    @JsonIgnore
    @JoinColumn(name = "ContentID")
    private Content content;

    @ManyToOne
    @MapsId("GenreId")
    @JsonIgnore
    @JoinColumn(name = "GenreId")
    private Genre genre;

    
    
    // standard constructors, getters, and setters
}