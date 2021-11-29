package com.course.movie.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;





@Entity
@Table(name = "ContentGenre")
@Getter
@Setter

class ContentGenre {

    @EmbeddedId
    @Column(name = "content_genre_id", nullable = false)
    @JsonIgnore
    ContentGenreKey id;

    @ManyToOne
    @MapsId("ContentID")
    @JsonIgnore
    @JoinColumn(name = "ContentID")
    Content content;

    @ManyToOne
    @MapsId("GenreId")
    @JoinColumn(name = "GenreId")
    Genre genre;

	public ContentGenreKey getId() {
		return id;
	}

	public void setId(ContentGenreKey id) {
		this.id = id;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

    
    
    // standard constructors, getters, and setters
}