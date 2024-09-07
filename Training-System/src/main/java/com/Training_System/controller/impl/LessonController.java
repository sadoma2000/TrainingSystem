package com.Training_System.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Training_System.model.Lesson;
import com.Training_System.service.interfaces.LessonService;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

	@Autowired
	private LessonService lessonService;

	@GetMapping
	public List<Lesson> getAllLessons() {
		return lessonService.getAllLessons();
	}
	@GetMapping("/getLessonsByCourseId/{courseId}")
	public List<Lesson> getLessonsByCourseId(@PathVariable Long courseId) {
		return lessonService.getLessonsByCourseId(courseId);
	}

	@GetMapping("/getLessonById/{id}")
	public Lesson getLessonById(@PathVariable Long id) {
		return lessonService.getLessonById(id);
	}

	@PostMapping("/addLesson")
	public String addLesson(@RequestBody Lesson lesson) {

		return lessonService.addLesson(lesson);
	}

	@PutMapping("/updateLesson")
	public String updateLesson(@RequestBody Lesson lesson) {

		return lessonService.updateLesson(lesson);
	}


	@DeleteMapping("/deleteLesson/{id}")
	public void deleteLesson(@PathVariable Long id) {
		lessonService.deleteLesson(id);
	}
}


