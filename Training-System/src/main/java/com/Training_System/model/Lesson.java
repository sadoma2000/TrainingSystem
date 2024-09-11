package com.Training_System.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@Column(columnDefinition = "VARCHAR(20) NOT NULL")
	private String Title;
	@Column(columnDefinition = "INT NOT NULL")
	private Integer lessonNumber;
	@Column(columnDefinition = "VARCHAR(20) NOT NULL")
	private String contentSummary;
}
