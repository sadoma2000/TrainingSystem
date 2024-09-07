package com.Training_System.service.interfaces;


import java.util.List;

import com.Training_System.model.Lesson;

public interface LessonService {

	List<Lesson> getAllLessons();
	List<Lesson> getLessonsByCourseId(Long courseId);
	Lesson getLessonById(Long id);
	String addLesson(Lesson lesson);
	String updateLesson(Lesson lesson);
	void deleteLesson(Long id);
}
