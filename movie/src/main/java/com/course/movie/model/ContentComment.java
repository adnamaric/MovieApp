package com.course.movie.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    
    // chech why this throws error
    @OneToMany(mappedBy = "UserID")
    @JsonIgnore
    List<User> User;
    
    @OneToMany(mappedBy = "ContentID")
    @JsonIgnore
    List<Content> Content;
//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="ContentID")
//    private List<Content> content;
//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="UserID")
//    private List<User> user;

    @Column(nullable = false)
    private String comment;

   
    
   

}