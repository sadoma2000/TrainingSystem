package com.Training_System.controller.impl;


import com.Training_System.model.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Training_System.model.Enrollment;
import com.Training_System.service.impl.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

	@Autowired
	private EnrollmentService enrollmentService;

	//  ****************************************************  GET  ****************************************************
	//Retrieve all enrolments
	@GetMapping("/get-all")
	public ResponseEntity getAllEnrollments() {
		return ResponseEntity.status(200).body(enrollmentService.getAllEnrollments());
	}

	//Retrieve a specific enrolment by ID
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity getEnrollmentById(@PathVariable Long id) {
		return ResponseEntity.status(200).body(enrollmentService.getEnrollmentById(id));
	}

	//  ***************************************************  POST  ****************************************************
	//Create a new enrolment
	@PostMapping("/add/{studentId}/{courseId}")
	public ResponseEntity createEnrollment(@PathVariable Long studentId, @PathVariable Long courseId, @RequestBody Enrollment enrollment) {
		enrollmentService.createEnrollment(studentId,courseId);
		return ResponseEntity.status(201).body("Enrollment added successfully");
	}

	//  ****************************************************  PUT  ****************************************************
	//Update an existing enrolment by ID
	@PutMapping("/update/{id}")
	public ResponseEntity updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
		enrollmentService.updateEnrollment(id, enrollment);
		return ResponseEntity.status(201).body("Enrollment updated successfully");
	}

	//ADD REJECT CONTROLLER

	//  **************************************************  DELETE  ***************************************************
	//Delete an enrolment by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteEnrollment(@PathVariable Long id) {
		enrollmentService.deleteEnrollment(id);
		return ResponseEntity.status(201).body("Enrollment deleted successfully");
	}
}
