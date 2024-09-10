package com.Training_System.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String topic;
	private Timestamp startDate;  
	private Timestamp endDate;

	@ManyToOne
	@JoinColumn(name = "instructor_id", referencedColumnName = "id")
	private Instructor instructor;  // Foreign key reference to Instructor

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Lesson> lessonList;

	@OneToMany(mappedBy = "certificate")
	private List<Certificate> certificateList = new ArrayList<>();

	@OneToMany(mappedBy = "enrollment")
	private List<Enrollment> enrollmentList = new ArrayList<>();

	@OneToMany(mappedBy = "progress")
	private List<Progress> progressList = new ArrayList<>();

	@OneToMany(mappedBy = "review")
	private List<Review> reviewList = new ArrayList<>();

	private Integer NumberOfLessons=0;
	private String courseLevel;
	private String description;
}
