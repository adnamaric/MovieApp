package com.course.movie.model;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
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
}