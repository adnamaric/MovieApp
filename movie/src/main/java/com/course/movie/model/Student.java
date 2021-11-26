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
    private int studentAge;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	
    

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