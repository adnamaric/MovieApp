package com.course.movie.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContentComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CommentID ;
    
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "UserID")
    private User user;
    
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "ContentID")
    private Content content;


    @Column(nullable = false)
    private String Comment;

   
    
   

}