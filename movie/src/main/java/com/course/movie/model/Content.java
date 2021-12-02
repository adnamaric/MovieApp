package com.course.movie.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ContentID ;

     @Column(nullable = false)
    private String Title;
    
    @Column(nullable = false)
    private Integer Year;
   
    @Column(nullable = false)
    private Integer Duration;
   /* 
    @Column(nullable = false)
    private Date RealaseDate;
    
    @Column(nullable = false)
    private float Rating;
    
    @Column(nullable = false)
    private String CoverLink;
    
    @Column(nullable = false)
    private String TrailerLink;
   
    @ManyToOne
    @JoinColumn(name = "ContentTypeID")
    private ContentType contentType;
    
    @ManyToOne
    @JoinColumn(name = "LanguageID")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "CountryID")
    private Country country;
    */
    @OneToMany(mappedBy = "genre")
    List<ContentGenre> contentGenre;

    
/*	public Integer getContentID() {
		return ContentID;
	}

	public void setContentID(Integer contentID) {
		ContentID = contentID;
	}

	public List<ContentGenre> getContentGenre() {
		return contentGenre;
	}

	public void setContentGenre(List<ContentGenre> contentGenre) {
		this.contentGenre = contentGenre;
	}
	*/
}