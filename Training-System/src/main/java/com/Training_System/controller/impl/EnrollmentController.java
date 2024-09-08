package com.Training_System.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Training_System.model.Enrollment;
import com.Training_System.service.impl.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

	@Autowired
	private EnrollmentService enrollmentService;

	//Retrieve all enrolments
	@GetMapping("/get-all")
	public List<Enrollment> getAllEnrollments() {
		return enrollmentService.getAllEnrollments();
	}


	//Retrieve a specific enrolment by ID
	@GetMapping("/get-by-id/{id}")
	public Enrollment getEnrollmentById(@PathVariable Long id) {
		return enrollmentService.getEnrollmentById(id);
	}

	//Create a new enrolment
	@PostMapping
	public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
		return enrollmentService.createEnrollment(enrollment);
	}

	//Update an existing enrolment by ID
	@PutMapping("/update/{id}")
	public Enrollment updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
		return enrollmentService.updateEnrollment(id, enrollment);
	}

	//Delete an enrolment by ID
	@DeleteMapping("/delete/{id}")
	public void deleteEnrollment(@PathVariable Long id) {
		enrollmentService.deleteEnrollment(id);
	}

}
