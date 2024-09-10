package com.Training_System.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String major;

	@OneToOne
	@MapsId
	private User user;

	@OneToMany(mappedBy = "certificate")
	private List<Certificate> certificateList = new ArrayList<>();

	@OneToMany(mappedBy = "enrollment")
	private List<Enrollment> enrollmentList = new ArrayList<>();

	@OneToMany(mappedBy = "progress")
	private List<Progress> progressList = new ArrayList<>();

	@OneToMany(mappedBy = "review")
	private List<Review> reviewList = new ArrayList<>();
}
