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
	
	@PostMapping("/add/{instructorId}/{courseId}")
        public ResponseEntity addLesson(@PathVariable Long instructorId, @PathVariable Long courseId, @RequestBody Lesson lesson) {
               String result = lessonService.addLesson(instructorId, courseId, lesson);
                return ResponseEntity.status(201).body(result);
        }

	//  ****************************************************  PUT  ****************************************************

	@PutMapping("/update/{lessonId}")
        public ResponseEntity updateLesson(@PathVariable Long lessonId, @RequestBody Lesson lesson) {
               lesson.setId(lessonId); 
               String result = lessonService.updateLesson(lesson);
               return ResponseEntity.status(201).body(result);
        }

	//  **************************************************  DELETE  ***************************************************
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteLesson(@PathVariable Long id) {
		lessonService.deleteLesson(id);
		return ResponseEntity.status(201).body("Lesson deleted successfully");
	}
}


