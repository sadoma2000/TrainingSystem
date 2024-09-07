package com.Training_System.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Training_System.model.Student;
import com.Training_System.service.impl.StudentServicempl;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentServicempl StudentService;

	@GetMapping
	public List<Student> getAllStudents() {
		return StudentService.getAllStudents();
	}

	@GetMapping("/getStudentById/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return StudentService.getStudentById(id);
	}

	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student student) {

		return StudentService.addStudent(student);
	}

	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student student) {

		return StudentService.updateStudent(student);
	}


	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable Long id) {
		StudentService.deleteStudent(id);
	}
}