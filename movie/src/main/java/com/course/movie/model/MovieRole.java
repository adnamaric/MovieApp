package com.course.movie.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table (name="movie_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MovieRoleID ;

    @Column(nullable = false)
    private String name;

  
    
   

}