package com.course.movie.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
   
//    @Column(nullable = true)
//    private Date RealaseDate;
    
//    @Column(nullable = false)
//    private float Rating;
    
//    @Column(nullable = true)
//    private String CoverLink;
//    
//    @Column(nullable = true)
//    private String TrailerLink;
   
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "ContentTypeID")
    private ContentType contentType;
    
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "LanguageID")
    private Language language;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "CountryID")
    private Country country;
 
    @OneToMany(mappedBy = "genre")
    List<ContentGenre> contentGenre;

    @OneToMany(mappedBy = "user")
    List<Review> review;
    
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