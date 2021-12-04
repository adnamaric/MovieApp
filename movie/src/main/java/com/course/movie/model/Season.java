package com.course.movie.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer SeasonID;

    @Column( nullable = false)
    private String seasonName;
    
    @Column( nullable = false)
    private Integer seasonNumber;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "trainId")
//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="ContentID")
//    private List<Content> content;
    
    
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "Content")
    private Content content;
    

    @OneToMany(mappedBy = "season")
    List<SerieCast> serieCast;
  //  private Integer contentID;
}