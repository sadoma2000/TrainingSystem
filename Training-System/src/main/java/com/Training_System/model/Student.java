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
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String major;

	@OneToOne
	@MapsId
	private AppUser user;

	@OneToMany(mappedBy = "student")
	private List<Certificate> certificateList = new ArrayList<>();

	@OneToMany(mappedBy = "student")
	private List<Enrollment> enrollmentList = new ArrayList<>();

	@OneToMany(mappedBy = "student")
	private List<Progress> progressList = new ArrayList<>();

	@OneToMany(mappedBy = "student")
	private List<Review> reviewList = new ArrayList<>();
}
