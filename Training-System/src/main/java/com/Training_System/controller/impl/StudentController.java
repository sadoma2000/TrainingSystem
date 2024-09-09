package com.Training_System.controller.impl;

import com.Training_System.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Training_System.model.Student;
import com.Training_System.service.impl.StudentServicempl;



@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentServicempl StudentService;


	//  ****************************************************  GET  ****************************************************
	@GetMapping("/get-all")
	public ResponseEntity getAllStudents() {
		return ResponseEntity.status(200).body(StudentService.getAllStudents());
	}

	@GetMapping("/get-by-id/{id}")
	public ResponseEntity getStudentById(@PathVariable Long id) {
		return ResponseEntity.status(200).body(StudentService.getStudentById(id));
	}

	//  ***************************************************  POST  ****************************************************
	@PostMapping("/add")
	public ResponseEntity addStudent(@RequestBody Student student) {
		StudentService.addStudent(student);
		return ResponseEntity.status(201).body("Student added successfully");
	}

	//  ****************************************************  PUT  ****************************************************
	@PutMapping("/update/{id}")
	public ResponseEntity updateStudent(@RequestBody Student student) {
		StudentService.updateStudent(student);
		return ResponseEntity.status(201).body("Student updated successfully");
	}

	//  **************************************************  DELETE  ***************************************************
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteStudent(@PathVariable Long id) {
		StudentService.deleteStudent(id);
		return ResponseEntity.status(201).body("Student deleted successfully");
	}
	}
