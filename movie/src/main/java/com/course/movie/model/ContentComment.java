package com.course.movie.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table
@Getter
@Setter
public class ContentComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CommentID ;
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    List<User> User;
    
    @OneToMany(mappedBy = "content")
    @JsonIgnore
    List<User> Content;
    
    @Column(nullable = false)
    private String comment;

   
    
   

}