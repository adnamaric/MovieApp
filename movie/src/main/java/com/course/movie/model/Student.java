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

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(nullable = false)
    private String studentName;

    @Column( nullable = false)
    private String studentAge;
    

   // @OneToMany(mappedBy = "faculty")
   // List<StudentFaculty> studentsOnFaculty;
    
   /* @ManyToMany
    @JoinTable(
      name = "studentsOnFaculty", 
      joinColumns = @JoinColumn(name = "studentId"), 
      inverseJoinColumns = @JoinColumn(name = "facultyId"))
    List<Faculty> attendedFaculties;
    
    */
    
   /*@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "composite_fk"),name = "facultyId", nullable = false)
	private Faculty facultyId;*/
    
    
    
}