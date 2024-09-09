package com.Training_System.controller.impl;


import com.Training_System.model.Certificate;
import com.Training_System.model.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Training_System.model.Lesson;
import com.Training_System.service.interfaces.LessonService;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

	@Autowired
	private LessonService lessonService;

	//  ****************************************************  GET  ****************************************************
	@GetMapping("/get-all")
	public ResponseEntity getAllLessons() {
		return ResponseEntity.status(200).body(lessonService.getAllLessons());
	}

	@GetMapping("/get-by-Lesson/{courseId}")
	public ResponseEntity getLessonsByCourseId(@PathVariable Long courseId) {
		return ResponseEntity.status(200).body(lessonService.getLessonsByCourseId(courseId));
	}

	@GetMapping("/get-by-id/{id}")
    public ResponseEntity getLessonById(@PathVariable Long id) {
		return ResponseEntity.status(200).body(lessonService.getLessonById(id));
	}

	//  ***************************************************  POST  ****************************************************
	@PostMapping("/add")
	public ResponseEntity addLesson(@RequestBody Lesson lesson) {
		lessonService.addLesson(lesson);
		return ResponseEntity.status(201).body("Lesson added successfully");
	}

	//  ****************************************************  PUT  ****************************************************
	@PutMapping("/update/{id}")
	public ResponseEntity updateLesson(@RequestBody Lesson lesson) {
		lessonService.updateLesson(lesson);
		return ResponseEntity.status(201).body("Lesson updated successfully");
	}

	//  **************************************************  DELETE  ***************************************************
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteLesson(@PathVariable Long id) {
		lessonService.deleteLesson(id);
		return ResponseEntity.status(201).body("Lesson deleted successfully");
	}
}


