package com.course.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserID ;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private Boolean active = true;
    
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

//    @Column(nullable = false)
//    private String phoneNumber;

    @Column(nullable = false)
    private String email;

//    @Column(nullable = false)
//    private String password;


}