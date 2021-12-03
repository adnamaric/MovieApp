package com.course.movie.model;

import java.sql.Date;
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
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoviePeople {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MoviePeopleID ;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = true)
    private Date birthDate;
    
    @Column(nullable = false)
    private char gender;

  @OneToMany(mappedBy = "moviePeople", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   List<MoviePeopleRole> moviePeopleRole;
}