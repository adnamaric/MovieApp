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
@Table(name = "episode")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer EpisodeID;

    @Column( nullable = false)
    private String episodeName;
    
    @Column( nullable = false)
    private int duration;

    @Column( nullable = false)
    private int episodeNumber;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="SeasonID")
     private List<Season> season;
    
   
}