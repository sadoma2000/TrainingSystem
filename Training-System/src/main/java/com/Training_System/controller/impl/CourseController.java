package com.Training_System.controller.impl;


import com.Training_System.model.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Training_System.model.Course;
import com.Training_System.repository.CourseRepository;
import com.Training_System.service.interfaces.ICourseService;

@RestController
@RequestMapping("/api/Course")
public class CourseController {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	ICourseService courseService;

	//  ****************************************************  GET  ****************************************************
	//@Override
	@GetMapping("/get-all")
	public ResponseEntity getAllCourses() {
		return ResponseEntity.status(200).body(courseRepository.findAll());
	}

	//  ***************************************************  POST  ****************************************************
	@PostMapping("/add/{instructorId}")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity saveCourse(@PathVariable Long instructorId, @RequestBody Course course) {
		courseService.saveCourse(instructorId,course);
		return ResponseEntity.status(201).body("Course added successfully");
	}

	//  ****************************************************  PUT  ****************************************************
	@PutMapping("/update/{id}")
	public ResponseEntity updateCourse(@RequestBody Course updatedCourse, @PathVariable Long id) {
		courseService.updateCourse(updatedCourse.getStartDate(),updatedCourse.getEndDate(), id);
		return ResponseEntity.status(201).body("Course updated successfully");
	}

	//  **************************************************  DELETE  ***************************************************
	@DeleteMapping("/delete/{id}")
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
		return ResponseEntity.status(201).body("Course deleted successfully");
	}
}
