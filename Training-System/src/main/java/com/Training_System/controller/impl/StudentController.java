package com.Training_System.controller.impl;

import com.Training_System.model.DTO.StudentDTO;
import com.Training_System.service.impl.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Training_System.model.Student;


@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {


	private final StudentService studentService;


	//  ****************************************************  GET  ****************************************************
	@GetMapping("/get-all")
	public ResponseEntity getAllStudents() {
		return ResponseEntity.status(200).body(studentService.getAllStudents());
	}

	@GetMapping("/get-by-id/{id}")
	public ResponseEntity getStudentById(@PathVariable Long id) {
		return ResponseEntity.status(200).body(studentService.getStudentById(id));
	}

	//  ***************************************************  POST  ****************************************************
	@PostMapping("/register")
	public ResponseEntity registerStudent(@RequestBody StudentDTO student) {
		studentService.registerStudent(student);
		return ResponseEntity.status(201).body("Student registered successfully");
	}

	//  ****************************************************  PUT  ****************************************************
	@PutMapping("/update/{id}")
	public ResponseEntity updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return ResponseEntity.status(201).body("Student updated successfully");
	}

	//  **************************************************  DELETE  ***************************************************
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.status(201).body("Student deleted successfully");
	}
	}
