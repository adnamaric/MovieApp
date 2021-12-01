package com.course.movie.model;



//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer GenreId;

    @Column(nullable = false)
    private String Name;

  
   /* @OneToMany(mappedBy = "content")
    List<ContentGenre> contentGenre;
    */



 
    
    
}