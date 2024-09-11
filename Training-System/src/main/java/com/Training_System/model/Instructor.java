package com.Training_System.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String department;
	private String languageSpoken;  


	@OneToMany(mappedBy = "instructor")
	private List<Course> courseList = new ArrayList<>();

	@OneToOne
	@MapsId
	private AppUser user;
}
