package com.Training_System.service.impl;

import com.Training_System.Api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Training_System.model.Lesson;
import com.Training_System.repository.LessonRepository;
import com.Training_System.service.interfaces.LessonService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class lessonServicempl implements LessonService{

	@Autowired
	private LessonRepository lessonRepository;

	// Get all lessons
	@Override
	public List<Lesson> getAllLessons() {
		return lessonRepository.findAll();
	}

	// Get lessons by course ID
	@Override
	public List<Lesson> getLessonsByCourseId(Long courseId) {
		List<Lesson> lessons = lessonRepository.findByCourseId(courseId);
		if (lessons.isEmpty()){
			throw new ApiException("Lesson not found with course id " + courseId);
		}
		return lessons;
	}

	// Get lesson by ID
	@Override
	public Lesson getLessonById(Long id) {
		return lessonRepository.findById(id)
				.orElseThrow(() -> new ApiException("Lesson not found with id " + id));
	}

	// Create a new lesson
	@Override
	public String addLesson(Lesson lesson) {
		Lesson exist = lessonRepository.findById(lesson.getId()).orElse(null);
		if (exist == null) {
			lessonRepository.save(lesson);
			return "Lesson Saved Successfully.";
		} else {
			throw new ApiException("Lesson Already Exists!");
		}
	}

	// Update an existing lesson
	@Override
	public String updateLesson(Lesson lesson) {
		Lesson exist = lessonRepository.findById(lesson.getId()).orElse(null);
		if (exist == null) {
			 throw new ApiException("No Lesson Exists!");
		} else {
			exist.setCourse(lesson.getCourse());
			exist.setTitle(lesson.getTitle());
			exist.setLesson_number(lesson.getLesson_number());
			exist.setContent_summary(lesson.getContent_summary());


			lessonRepository.save(exist);
			return "Lesson Updated Successfully!";
		}
	}

	@Override
	public void deleteLesson(Long id) {
		Lesson lesson = getLessonById(id);
		lessonRepository.delete(lesson);
	}
}

