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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@Column(columnDefinition = "DATE NOT NULL")
	private LocalDate issuedDate;

	@Column(columnDefinition = "VARCHAR(20) NOT NULL")
	private String certificateTitle;
}
