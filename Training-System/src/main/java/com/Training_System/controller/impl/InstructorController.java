package com.Training_System.controller.impl;


import com.Training_System.model.Course;
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

import com.Training_System.controller.interfaces.IInstructorController;
import com.Training_System.model.Instructor;
import com.Training_System.repository.InstructorRepository;
import com.Training_System.service.interfaces.IInstructorService;

@RestController
@RequestMapping("/api/Instructors")
public class InstructorController implements IInstructorController{

	@Autowired
	InstructorRepository instructorRepository;

	@Autowired
	IInstructorService instructorService;

	//  ****************************************************  GET  ****************************************************
	@GetMapping("/get-all")
	public ResponseEntity getAllInstructors() {
		return ResponseEntity.status(200).body(instructorRepository.findAll());
	}

	//  ***************************************************  POST  ****************************************************
	@PostMapping("/add")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity saveInstructor(@RequestBody Instructor instructor) {
		instructorService.saveInstructor(instructor);
		return ResponseEntity.status(201).body("Instructor added successfully");
	}

	//  ****************************************************  PUT  ****************************************************
	@PutMapping("/update/{id}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity updateInstructor(@RequestBody Instructor instructor, @PathVariable Long id) {
		instructorService.updateInstructor(instructor.getLanguageSpoken(), id);
		return ResponseEntity.status(201).body("Instructor updated successfully");
	}

	//  **************************************************  DELETE  ***************************************************
	@DeleteMapping("/delete/{id}")
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity deleteExercise(@PathVariable Long id) {
		instructorService.deleteInstructor(id);
		return ResponseEntity.status(201).body("Instructor deleted successfully");
	}
}
