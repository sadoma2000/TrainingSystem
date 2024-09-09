package com.Training_System.model;


import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {
	//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;

	@Column(name = "issued_date")
	private LocalDate issuedDate; //changed

	@Column(name = "certificate_title")
	private String certificateTitle;
}
